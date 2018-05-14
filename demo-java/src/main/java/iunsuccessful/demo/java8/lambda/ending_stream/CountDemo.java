package iunsuccessful.demo.java8.lambda.ending_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by LiQZ on 2016/12/5.
 */
public class CountDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList() {
            {
                add(12);
                add(20);
                add(12);
                add(22);
                add(22);
                add(23);
                add(159);
                add(12);
            }
        };

        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

}
