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
        map.computeIfAbsent("key", key -> 1);
        map.computeIfAbsent("key", key -> 1);
        // 如果 key 在 map 中不存在，就在 map 里加入 key，如果存在，就 value + 1
        map.compute("key1", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        map.compute("key1", (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);

        // 没有值的时候，起用用的 3
        map.merge("key2", 3, (oldValue, newValue) -> newValue + 1);
        // 有值的话，会用 5 + 1
        map.merge("key2", 5, (oldValue, newValue) -> oldValue + newValue + 1);

        System.out.println(map);

    }

}
