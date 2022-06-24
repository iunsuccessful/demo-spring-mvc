package iunsuccessful.demo.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * 依韵 2022/6/24
 */
public class MapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 如果 key 在 map 中不存在，就在 map 里加入 key
        map.computeIfAbsent("key", k -> 1);
        map.computeIfAbsent("key", k -> 1);
        // 如果 key 在 map 中不存在，就在 map 里加入 key，如果存在，就 value + 1
        map.compute("key1", (k, v) -> v == null ? 1 : v + 1);
        map.compute("key1", (k, v) -> v == null ? 1 : v + 1);

        System.out.println(map);

    }

}
