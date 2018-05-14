package iunsuccessful.demo.java8.lambda.ending_stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author LiQZ on 2016/9/7.
 */
public class BestPractice {

    /**
     * Stream 转换在 Array
     * 类似的 Stream 跟 List 之间的转换
     * http://www.programcreek.com/2014/01/convert-stream-to-array-in-java-8/
     */
    private static void streamToArray() {
        String[] stringArr = { "a", "b", "c", "d" };
        Stream<String> stream = Stream.of(stringArr);
        String[] arr = stream.toArray(size -> new String[size]);
//        String[] arr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));

        List<String> list = Lists.newArrayList("abc", "123");
        // list.stream()
        Stream.of(list).forEach(System.out::println);
        Stream.of(list).collect(toList());


    }

    /**
     * 统计出现次数
     * http://www.programcreek.com/2014/01/how-to-write-a-counter-in-java-8/
     */
    public static void counter() {
        String[] arr = { "program", "creek", "program", "creek", "java", "web",  "program" };
        Stream<String> stream = Stream.of(arr).parallel();
        Map<String, Long> counter = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println(counter.get("creek"));
    }

    /**
     * 连接两个 Stream
     * http://www.programcreek.com/2014/01/concat-streams-in-java-8/
     */
    private static void concatStreams() {
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "e", "f", "g" };
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);

        Stream<String> stream3 = Stream.concat(stream1, stream2);
//        String[] arr = stream3.toArray(String[]::new);
        String[] arr = stream3.toArray(size -> new String[size]);
        System.out.println(Arrays.toString(arr));
    }




}
