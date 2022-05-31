package iunsuccessful.demo.common.utils;

import com.google.common.collect.Multimap;
import org.apache.commons.collections.Bag;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author LiQZ on 2016/4/29.
 */
public class PrintUtils {

    public static <T> void print(List<T> list) {
        System.out.println("------------- list ------------");
        list.forEach(System.out::println);
    }

    public static void printBag(Bag bag) {
        System.out.println("------------- bag ------------");
        bag.uniqueSet().forEach(o -> System.out.printf("%s %s\n", o, bag.getCount(o)));
    }

    public static <T> void print(Collection<T> collections) {
        System.out.println("------------- collections ------------");
        collections.forEach(PrintUtils::print);
    }

    public static <T> void print(Object obj) {
        System.out.println("------------- Object ------------");
        System.out.println(obj);
    }

    public static void print(int[] t) {
        System.out.print("[");
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]);
            if (i < t.length - 1) {
                System.out.print(" ,");
            }
        }
        System.out.println("]");
    }

    public static void print(String[] strings) {
        print(Arrays.asList(strings));
    }

    public static <K, V> void print(Map<K, V> map) {
        System.out.println("------------- map ------------");
        map.forEach((k, v) -> System.out.println("{key: " + k + ", value: " + v + "}"));

    }

    public static void print(Multimap multimap) {
        print(multimap.asMap());
    }


    public static void print(LocalDateTime localDateTime, String pattern) {
        System.out.println("---------- local date time -------------");
        String formatterTime = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        System.out.println(formatterTime);
    }

    public static void print(ZonedDateTime zonedDateTime, String pattern) {
        System.out.println("---------- zone date time -------------");
        String formatterTime = zonedDateTime.format(DateTimeFormatter.ofPattern(pattern));
        System.out.println(formatterTime);
    }

}
