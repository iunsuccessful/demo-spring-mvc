package iunsuccessful.demo.java8.lambda.collect;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Create By LiQZ 2018/9/10
 */
public class MapListFilterDemo {


    /**
     * 过滤掉 list 里面的 2
     * @param args
     */
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        map.put(256, list1);
        List<Integer> list2 = Arrays.asList(2, 2, 7);
        map.put(258, list2);

        map.values().forEach(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                integers = integers.stream().filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer != 2;
                    }
                }).collect(Collectors.toList());
            }
        });

        PrintUtils.print(map);

    }

}
