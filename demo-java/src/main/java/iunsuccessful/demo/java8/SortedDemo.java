package iunsuccessful.demo.java8;

import com.google.common.collect.Lists;
import iunsuccessful.demo.common.utils.DataUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Comparison method violates its general contract!
 * 依韵 2020/11/14
 */
public class SortedDemo {

    public static void main(String[] args) {

        // https://www.cnblogs.com/firstdream/p/7204067.html
        // 不是所有的情况都会报错，只有特定的数组，最后采用 TimSort 才会报错
//        List<Integer> datd = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
//                0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 2, 30, 0, 3);

        List<Integer> datd = Arrays.asList(1800, 2000, 2000, 2000, 2000, 2000, 3000, 2000, 3000, 2000);

        datd.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                if (o1 == o2) {
//                    return 0;
//                }
                return o1 > o2 ? 1: -1;
            }
        }).forEach(System.out::println);

    }

}
