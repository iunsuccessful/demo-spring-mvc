package iunsuccessful.demo.base.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Create By LiQZ 2019/1/14
 */
public class MapOrderedDemo {

    public static void main(String[] args) {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(3, 3);
        map1.put(1, 1);
        map1.put(4, 4);
        map1.put(17, 17);
        map1.keySet().forEach(System.out::println);

        System.out.println("###############");

        Map<Integer, Integer> map2 = new LinkedHashMap<>();
        map2.put(3, 3);
        map2.put(1, 1);
        map2.put(4, 4);
        map2.put(17, 17);
        map2.keySet().forEach(System.out::println);

        System.out.println("###############");

        Map<Integer, Integer> map3 = new TreeMap<>();
        map3.put(3, 3);
        map3.put(1, 1);
        map3.put(4, 4);
        map3.put(17, 17);
        map3.keySet().forEach(System.out::println);

    }

}
