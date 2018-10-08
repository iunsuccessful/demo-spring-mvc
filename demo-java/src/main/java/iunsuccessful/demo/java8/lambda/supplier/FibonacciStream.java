package iunsuccessful.demo.java8.lambda.supplier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Supplier Demo generate Fibonacci.
 *
 * @author LiQZ on 2016/5/9.
 */
//class FibonacciSupplier implements Supplier<Long> {
//
//    long a = 0;
//    long b = 1;
//
//    @Override
//    public Long get() {
//        long x = a + b;
//        a = b;
//        b = x;
//        return a;
//    }
//}

public class FibonacciStream {

    public static void main(String[] args) {
        Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());
        fibonacci.skip(3).limit(10).forEach(System.out::println);
        List<Long> list = Stream.generate(new FibonacciSupplier()).skip(1).limit(10).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

}
