package iunsuccessful.demo.vavr;

import io.vavr.control.Try;

/**
 * 依韵 2021/12/25
 */
public class TryDemo {

    public static void main(String[] args) {
        // demo1();
        // demo2();
        demo3();
    }

    private static void demo1() {

        System.out.println(divide(80, 0).onFailure(throwable -> System.out.println("fail")).getOrElse(0));
    }

    private static void demo2() {
        Integer result = Try.of(() -> divide2(80, 0)).getOrElse(0);
        System.out.println(result);
    }

    private static void demo3() {
        int x = 1; int y = 2;
        // 这个抛出 Throwable 异常
        Try<Integer> tryInteger1 = Try.of(() -> x + y);
        // 这个方法不会抛出异常
        Try<Integer> tryInteger2 = Try.ofSupplier(() -> x + y);
        // 这个方法会抛出异常
        Try<Integer> tryInteger3 = Try.ofCallable(() -> x + y);
        // 这个没有返回值
        Try tryInteger4 = Try.run(() -> { System.out.println(x + y); });


        System.out.println(tryInteger1.get());
        System.out.println(tryInteger2.get());
        System.out.println(tryInteger3.get());
        tryInteger4.get();

    }

    static Try<Integer> divide(Integer dividend, Integer divisor) {
        return Try.of(() -> dividend / divisor);
    }

    static Integer divide2(Integer dividend, Integer divisor) {
        return dividend / divisor;
    }

}
