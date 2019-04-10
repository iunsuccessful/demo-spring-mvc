package iunsuccessful.demo.base.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By LiQZ 2018/7/12
 */
public class HashMapSourceAnalyze {

    public static void main(String[] args){
        System.out.println(hash(20));
        System.out.println(hash("a"));
        System.out.println(hash("中国aaaaaaa"));
        Map<String, String> map = new HashMap<>();
        map.put("中国aaaaaaa", null);
        System.out.println(tableSizeFor(3));
//        System.out.println(1 << 30);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
