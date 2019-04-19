package iunsuccessful.demo.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import iunsuccessful.demo.common.domain.ApiResponse;
import iunsuccessful.demo.common.domain.Point;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Create By LiQZ 2019/4/9
 */
public class Demo1 {

    public static void main(String[] args) {
        demo2();
    }

    private static void demo1() {
        Gson gson = new Gson();
        ApiResponse response = gson.fromJson("{data:{x:1,y:2}}", ApiResponse.class);
        Point point = gson.fromJson(response.getData().toString(), Point.class);
        System.out.println(response.getData());
        System.out.println(point);
    }

    /**
     * {id=13.0, showName=小败, mobile=18260081109,
     * password=1798d3ec37d7fbc21c7f24a0d9c46dd2be15c1ff0ed9a2747622bae4202830fa,
     * salt=twhliTGbOL,
     * isAdmin=1.0,
     * status=0.0,
     * lastSignTime=2019-04-10 00:21:49,
     * gmtCreate=null, gmtModified=null}
     */
    private static void demo2() {
        Type type = new TypeToken<List<Point>>() {}.getType();
        Gson gson = new Gson();
        ApiResponse response = gson.fromJson("{data:[{x:1,y:2}]}", ApiResponse.class);

        List<Point> points = gson.fromJson(response.getData().toString(), type);
        System.out.println(response.getData());
        System.out.println(points);
    }

}
