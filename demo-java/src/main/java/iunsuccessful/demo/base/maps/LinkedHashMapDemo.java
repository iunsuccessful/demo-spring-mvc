package iunsuccessful.demo.base.maps;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 没法直接通过 value 排序，只能通过先排序，然后插入 Linked Hash Map 里面
 * 依韵 2021/9/11
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {

        Map<String, List<String>> map = new TreeMap<>();

        map.put("a", Arrays.asList("1", "2"));
        map.put("b", Arrays.asList("1"));
        map.put("c", Arrays.asList("1", "2", "3"));

        PrintUtils.print(map);

        map.entrySet().stream().sorted(new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
                return 0;
            }
        }).forEach(new Consumer<Map.Entry<String, List<String>>>() {
            @Override
            public void accept(Map.Entry<String, List<String>> stringListEntry) {

            }
        });

    }

}
