package iunsuccessful.demo.java8.stream;

import java.util.stream.Stream;

/**
 * 依韵 2021/9/1
 */
public class DemoJoin {

    public static void main(String[] args) {
        String temp = Stream.of("a", "b", "c").reduce((a, b) -> { return a + "_" + b;}).get();
        System.out.println(temp);
    }

}
