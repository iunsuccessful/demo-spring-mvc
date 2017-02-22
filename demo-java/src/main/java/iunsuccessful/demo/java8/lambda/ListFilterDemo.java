package iunsuccessful.demo.java8.lambda;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by LiQZ on 2017/2/17.
 */
public class ListFilterDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("");
        list.add("123");
        list.add("1");
        list.add("123");
        list = list.stream().filter(bean -> !"1".equals(bean)).collect(Collectors.toList());
        PrintUtils.print(list);
    }

}
