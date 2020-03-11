package iunsuccessful.demo.patterns.trampoline;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 依韵 2019/11/27
 */
public class StreamDemo {

    private AtomicInteger id = new AtomicInteger();

    public static void demo1() {

        Integer result = loop(18000, 1).result();

        System.out.println(result);

    }

    public static Trampoline<Integer> loop(int times, int prod) {
        if (times == 0) {
            return Trampoline.done(prod);
        } else {
            return Trampoline.more(() -> loop(times - 1, prod + times));
        }
    }

//    public static Integer loop(int times, int prod) {
//        if (times == 0) {
//            return prod;
//        } else {
//            return loop(times -1, prod + times);
//        }
//    }

}
