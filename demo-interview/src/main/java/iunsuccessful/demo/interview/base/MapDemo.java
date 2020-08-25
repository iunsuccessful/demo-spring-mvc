package iunsuccessful.demo.interview.base;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by LiQZ on 2017/9/12.
 */
public class MapDemo {

    public static void main(String[] args) {
        // 问题：HashMap 中 key 可不可以为 null, value 可不可以为 null ?
        Map map = new HashMap<>();
        // 可以
        map.put(null, null);

        System.out.println(map);
        Map map2 = new TreeMap<>();
        map2.put(null, null);
        System.out.println(map2);
    }

}
