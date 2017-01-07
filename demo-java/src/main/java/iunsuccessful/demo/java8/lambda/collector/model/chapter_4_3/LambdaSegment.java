package iunsuccessful.demo.java8.lambda.collector.model.chapter_4_3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Use Java 8 Lambda collector segment.
 * Created by Anonymous on 1/7/2017.
 */
public class LambdaSegment {

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
    private static BiConsumer<Deque<Deque<Point>>,Point> accumulator = new BiConsumer<Deque<Deque<Point>>, Point>() {
        @Override
        public void accept(Deque<Deque<Point>> ddp, Point p) {
            Deque<Point> last = ddp.getLast();
            if (!last.isEmpty() && last.getLast().distance(p) > NormalSegment.MAX_DISTANCE) {
                Deque<Point> dp = new ArrayDeque<>();
                dp.add(p);
                ddp.add(dp);
            } else {
                last.add(p);
            }
        }
    };

    /**
     * 组合器
     */
    private static BinaryOperator<Deque<Deque<Point>>> combiner = new BinaryOperator<Deque<Deque<Point>>>() {
        @Override
        public Deque<Deque<Point>> apply(Deque<Deque<Point>> left, Deque<Deque<Point>> right) {
            Deque<Point> leftLast = left.getLast();
            if (leftLast.isEmpty()) return right;
            Deque<Point> rightFirst = right.getFirst();
            if (rightFirst.isEmpty()) return left;
            Point p = rightFirst.getFirst();
            if (leftLast.getLast().distance(p) <= NormalSegment.MAX_DISTANCE) {
                leftLast.addAll(rightFirst);
                right.removeFirst();
            }
            left.addAll(right);
            return left;
        }
    };



    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(3, 0), new Point(6, 0), new Point(8,0), new Point(10, 0), new Point(14,0));
        // target -> collect supplier, accumulator (积聚器), combiner
        Deque<Deque<Point>> segmentPoints = points.stream().collect(Collector.of(supplier, accumulator, combiner));
        System.out.println(segmentPoints);

    }

}
