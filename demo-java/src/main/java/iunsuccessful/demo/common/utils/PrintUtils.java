package iunsuccessful.demo.common.utils;

import com.google.common.collect.Multimap;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author LiQZ on 2016/4/29.
 */
public class PrintUtils {

    public static <T> void print(List<T> list) {
        System.out.println("------------- list ------------");
        list.stream().forEach(System.out::println);
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
