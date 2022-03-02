package iunsuccessful.demo.vavr;

import io.vavr.control.Try;

/**
 * 依韵 2021/12/25
 */
public class TryDemo {

    public static void main(String[] args) {
        // demo1();
        demo2();
    }

    private static void demo1() {

        System.out.println(divide(80, 0).onFailure(throwable -> System.out.println("fail")).getOrElse(0));
    }

    private static void demo2() {
        Integer result = Try.of(() -> divide2(80, 0)).getOrElse(0);
        System.out.println(result);
    }

    static Try<Integer> divide(Integer dividend, Integer divisor) {
        return Try.of(() -> dividend / divisor);
    }

    static Integer divide2(Integer dividend, Integer divisor) {
        return dividend / divisor;
    }

}
