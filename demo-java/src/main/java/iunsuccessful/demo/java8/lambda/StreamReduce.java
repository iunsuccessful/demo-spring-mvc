package iunsuccessful.demo.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * reduce: 压缩
 * stream 流是一个集合，跟 array,list 差不多
 * @author LiQZ on 2016/9/7.
 */
public class StreamReduce {

    public static void main(String[] args) {
        collect();
    }

    /**
     * 聚合，比如：对 list 里面数据长度进行求和.
     * 由多个变成一个的过程。
     */
    private static void reduce() {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("php");
        list.add("python");
        list.add("perl");
        list.add("c");
        list.add("lisp");
        list.add("c#");
        Stream<String> wordStream = list.stream();

        Stream<Integer> lengthStream = wordStream.map(String::length);
//        Optional<Integer> sum = lengthStream.reduce((x, y) -> x + y);
        Optional<Integer> sum = lengthStream.reduce(Integer::sum);
        sum.ifPresent(System.out::println);
    }

    /**
     * 跟上面相反，从 Stream 变成集合的过程。
     */
    private static void collect() {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("php");
        list.add("python");
        Stream<String> wordStream = list.stream();
        // to map
        Map<String, Integer> map = wordStream.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);
    }

}
