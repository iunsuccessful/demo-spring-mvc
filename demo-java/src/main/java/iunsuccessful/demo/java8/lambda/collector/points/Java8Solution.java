package iunsuccessful.demo.java8.lambda.collector.points;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 提供器，积聚器，组合器
 * Created by LiQZ on 2017/7/19.
 */
public class Java8Solution {

    /**
     * 提供器
     */
    private static Supplier<Deque<Deque<Point>>> supplier = () -> {
        Deque<Deque<Point>> ddp = new ArrayDeque<>();
        ddp.add(new ArrayDeque<>());
      return ddp;
    };

    /**
     * 积聚器
     */
    private static BiConsumer<Deque<Deque<Point>>, Point> accumulator = (ddp, p) -> {
        Deque<Point> deque = ddp.getLast();
        if (deque.isEmpty() || p.distance(deque.getLast()) <= Data.MAX_DISTANCE) {
            deque.add(p);
        } else {
            ddp.add(new ArrayDeque<>());
            ddp.getLast().add(p);
        }
    };

    /**
     * 组合器( parallel 模式用)
     * 它这里默认 right 就比 left 大，所以我们只需要考虑 left.last.last 要不要跟 right.first.first 合并问题
     */
    private static BinaryOperator<Deque<Deque<Point>>> combiner = (left, right) -> {
        Deque<Point> leftLast = left.getLast();
        if (leftLast.isEmpty()) {
            return right;
        }
        Deque<Point> rightFirst = right.getFirst();
        if (rightFirst.isEmpty()) {
            return left;
        }
        // 都不为空，看看两个怎么合并
        if (leftLast.getLast().distance(rightFirst.getFirst()) <= Data.MAX_DISTANCE) {
            // 两个要合并
            leftLast.addAll(rightFirst);
            right.removeFirst();
        }

        left.addAll(right);

        return left;
    };

    public static void main(String[] args) {
        Deque<Deque<Point>> collect = Data.getSortedPointList().stream().collect(Collector.of(supplier, accumulator, combiner));
        PrintUtils.print(collect);
    }

}
