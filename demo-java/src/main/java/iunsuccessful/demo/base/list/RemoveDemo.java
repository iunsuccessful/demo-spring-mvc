package iunsuccessful.demo.base.list;

import com.google.common.collect.Lists;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * list<integer>  remove 测试
 * Created by LiQZ on 2018/3/22.
 */
public class RemoveDemo {

    public static void main(String[] args) {
        List<Integer> productIds = new ArrayList<>();
        productIds.add(1);
        productIds.add(2);
        productIds.add(3);
        productIds.add(4);
//        System.out.println(productIds);
//        productIds.remove(1);
//        System.out.println(productIds);
//        productIds.remove(new Integer(1));
//        System.out.println(productIds);

//        List<Integer> allFloors = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> allFloors = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        allFloors.add(11);
        PrintUtils.print(allFloors);
        allFloors.remove(new Integer(1));
        PrintUtils.print(allFloors);

        allFloors.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 2;
            }
        });
        PrintUtils.print(allFloors);
    }

}
