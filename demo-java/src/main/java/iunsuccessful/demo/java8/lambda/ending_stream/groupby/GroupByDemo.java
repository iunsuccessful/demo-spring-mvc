package iunsuccessful.demo.java8.lambda.ending_stream.groupby;

import iunsuccessful.demo.common.utils.DataUtils;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * 分组
 * Created by LiQZ on 2017/7/17.
 */
public class GroupByDemo {

    public static void main(String[] args) {
//        groupBy1();
//        groupBy2();
//        groupBy3();
        groupBy4();
    }

    /**
     * 统计相同出现字母
     */
    private static void groupBy1() {
        List<String> list = DataUtils.getRandomList(10);
        PrintUtils.print(list);
        list.stream().collect(groupingBy(s -> s.charAt(0))).forEach((s, strings) -> {
            System.out.printf("########### %s ##########\n", s);
            PrintUtils.print(strings);
        });
    }

    /**
     * 统计相同开头字母的出现次数
     */
    private static void groupBy2() {
        List<String> list = DataUtils.getRandomList(10);
        PrintUtils.print(list);
        list.stream().collect(groupingBy(s -> s.charAt(0), Collectors.counting())).forEach(new BiConsumer<Character, Long>() {
            @Override
            public void accept(Character character, Long aLong) {
                System.out.printf("character %s count %d\n", character, aLong);
            }
        });
    }

    /**
     * 对应字符
     */
    private static void groupBy3() {
        List<String> list = DataUtils.getRandomList(10);
        PrintUtils.print(list);
        list.stream().collect(groupingBy(s -> s.charAt(0), mapping(s -> s, joining(";")))).forEach(new BiConsumer<Character, String>() {
            @Override
            public void accept(Character character, String s) {
                System.out.printf("character %s s %s\n", character, s);
            }
        });
    }

    /**
     * 相同字符最多的那个
     */
    private static void groupBy4() {
        List<String> list = DataUtils.getRandomList(10);
        PrintUtils.print(list);
        Optional<Character> c =  list.stream().collect(groupingBy(s -> s.charAt(0), counting())).entrySet()
                .stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        System.out.println(c.orElse('\n'));
    }

}
