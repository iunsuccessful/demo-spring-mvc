package iunsuccessful.demo.java8.lambda;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by LiQZ on 2016/12/26.
 */
public class StreamJoinDemo {

    public static void main(String[] args) {
//        String fields = Arrays.asList("id", "name", "url").stream().collect(Collectors.joining(","));
        String fields = Stream.of("id", "name", "url").collect(Collectors.joining(","));
        System.out.println(fields);
    }

}
