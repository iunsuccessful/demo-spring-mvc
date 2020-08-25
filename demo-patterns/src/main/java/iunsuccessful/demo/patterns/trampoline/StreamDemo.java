package iunsuccessful.demo.patterns.trampoline;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 依韵 2019/11/27
 */
public class StreamDemo {

    private AtomicInteger id = new AtomicInteger();

    public static void main(String[] args) {

//        Integer result = loop(18000, 1).result();

//        System.out.println(result);

        System.out.println(loop2(100, 1));
    }

    public static Trampoline<Integer> loop(int times, int prod) {
        if (times == 0) {
            return Trampoline.done(prod);
        } else {
            return Trampoline.more(() -> loop(times - 1, prod + times));
        }
    }

    public static Integer loop2(int times, int prod) {
        if (times == 0) {
            return prod;
        } else {
            return loop2(times -1, prod + times);
        }
    }

}
