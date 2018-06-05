package iunsuccessful.demo.java8.lambda.random;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Create By LiQZ 2018/5/7
 */
public class Demo {

    public static void main(String[] args) {
        int productSize = 10;
        List<Integer> ss = new Random().ints(0, 150)
                .distinct()
                .limit(Math.min(20, productSize))
                .mapToObj(value -> value + 50).collect(Collectors.toList());

        PrintUtils.print(ss);
        System.out.println(1 << 0);
    }

}
