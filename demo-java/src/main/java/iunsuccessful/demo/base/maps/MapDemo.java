package iunsuccessful.demo.base.maps;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 声名加赋值
 * Created by LiQZ on 2017/6/28.
 */
public class MapDemo {

    private static Map<String, String> properties = new HashMap<String, String>(){
        {
            put("demo1", "demo1");
        }
    };



    public static void main(String[] args) {
        PrintUtils.print(properties);

        Map<Integer, Integer> params = new HashMap<>();
        System.out.println(params.getOrDefault(2, 0));

    }

}
