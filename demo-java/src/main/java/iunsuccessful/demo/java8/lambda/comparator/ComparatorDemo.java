package iunsuccessful.demo.java8.lambda.comparator;

import iunsuccessful.demo.common.domain.Fighter;
import iunsuccessful.demo.common.domain.Point;
import iunsuccessful.demo.common.utils.DataUtils;

import java.util.Comparator;
import java.util.List;

/**
 * 依韵 2022/5/31
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        // 克服字段有 null 值的问题

        List<Fighter> pointList = DataUtils.getRandomFighters(10);

        pointList.get(5).setName(null);

        pointList.sort(Comparator.comparing(p -> p.getName(), Comparator.nullsLast(String::compareTo)));

        pointList.forEach(System.out::println);

//        orderEntryList.sort(Comparator.comparing(OrderEntry::getStorageAreaFeature, Comparator.nullsLast(String::compareTo))
//                .thenComparing(OrderEntry::getStorageFeature, Comparator.nullsLast(String::compareTo)));
    }

}
