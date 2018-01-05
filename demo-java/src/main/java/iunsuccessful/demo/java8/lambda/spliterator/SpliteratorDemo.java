package iunsuccessful.demo.java8.lambda.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

/**
 * 分割器运用
 * http://ifeve.com/java8-stream-%E4%B8%ADspliterator%E7%9A%84%E4%BD%BF%E7%94%A8%E4%B8%80/
 * Created by LiQZ on 2017/12/22.
 */
public class SpliteratorDemo {

    public static void main(String[] args) {

        Spliterator ls = new HelloSpliterator(0, 100);
        StreamSupport.stream(ls, true)
                .forEachOrdered(System.out::println);
    }

}

class HelloSpliterator implements Spliterator {

    private int begin, end;

    public HelloSpliterator(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public boolean tryAdvance(Consumer action) {

        action.accept(String.format("begin: %d end: %d - %s\n", begin, end, this.toString()));

        return false;
    }

    @Override
    public Spliterator trySplit() {

        int mid = (begin + end) >>> 1; // 除以 2, 取中间的意思

        return end - mid < 50 ? null : new HelloSpliterator(begin, begin = mid);
    }

    @Override
    public long estimateSize() {
        return 2;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
