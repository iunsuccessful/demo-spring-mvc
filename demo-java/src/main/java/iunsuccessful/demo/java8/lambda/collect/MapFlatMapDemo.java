package iunsuccessful.demo.java8.lambda.collect;

import iunsuccessful.demo.common.utils.DataUtils;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create By LiQZ 2018/7/20
 */
public class MapFlatMapDemo {

    public static void main(String[] args){
        List<String> list = DataUtils.getRandomList(10);
        PrintUtils.print(list);
//        List<Integer> lens = list.stream().map(String::length).collect(Collectors.toList());
        List<String> list1 = list.stream().flatMap(new Function<String, Stream<String>>() {
            @Override
            public Stream<String> apply(String s) {
                return Stream.of(s.split(""));
            }
        }).collect(Collectors.toList());
        PrintUtils.print(list1);
    }

}
