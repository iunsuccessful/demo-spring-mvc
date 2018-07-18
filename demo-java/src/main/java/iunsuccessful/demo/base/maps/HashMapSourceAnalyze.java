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
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
