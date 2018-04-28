package iunsuccessful.demo.java8.lambda.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * collect 加入现有 list
 * https://stackoverflow.com/questions/22753755/how-to-add-elements-of-a-java8-stream-into-an-existing-list
 * 结论：不要这么做
 * Created by LiQZ on 2018/3/22.
 */
public class Demo1 {

    public static void main(String[] args) {
        List<String> destList = new ArrayList<>(Arrays.asList("foo"));
        List<String> newList = Arrays.asList("0", "1", "2", "3", "4", "5");
        newList.stream().collect(Collectors.toCollection(() -> destList));
        System.out.println(destList);
        newList.parallelStream().collect(Collectors.toCollection(() -> destList));
        System.out.println(destList);
    }

}
