package iunsuccessful.demo.base.spi;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.*;

/**
 * 利用 SPI 调用 ComparatorProvider
 *
 * Created by LiQZ on 2017/5/10.
 */
public class ComparatorDemo {

    private static ServiceLoader<Comparator> serviceLoader = ServiceLoader.load(Comparator.class);

    public static void main(String[] args) {
        List<String> items = new ArrayList<String>() {
            {
                add("c");
                add("a");
                add("e");
                add("d");
                add("b");
            }
        };

        PrintUtils.print(items);

        Collections.sort(items, getComparator());

        PrintUtils.print(items);

    }

    private static Comparator getComparator() {
        if (serviceLoader.iterator().hasNext()) {
            return serviceLoader.iterator().next();
        }
        return null;
    }


}
