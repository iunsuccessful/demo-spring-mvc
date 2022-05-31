package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.Streams;

import java.util.Arrays;

/**
 * 依韵 2022/5/5
 */
public class ZipDemo {

    public static void main(String[] args) {

        String[] strings = {"a", "b", "c"};
        String[] strings2 = {"a", "b"};
        Streams.zip(Arrays.stream(strings), Arrays.stream(strings2), (a, b) -> a + b).forEach(System.out::println);

    }

}
