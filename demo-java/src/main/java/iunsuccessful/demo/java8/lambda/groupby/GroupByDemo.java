package iunsuccessful.demo.java8.lambda.groupby;

import iunsuccessful.demo.common.utils.DataUtils;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

/**
 * 分组
 * Created by LiQZ on 2017/7/17.
 */
public class GroupByDemo {

    public static void main(String[] args) {
        groupBy1();
    }

    private static void groupBy1() {
        List<String> list = DataUtils.getRandomList(10);
        PrintUtils.print(list);
        list.stream().collect(groupingBy(s -> s.charAt(0))).forEach((s, strings) -> {
            System.out.printf("########### %s ##########\n", s);
            PrintUtils.print(strings);
        });
    }

}
