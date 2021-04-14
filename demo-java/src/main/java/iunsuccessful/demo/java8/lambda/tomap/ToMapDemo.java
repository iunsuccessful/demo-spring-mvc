package iunsuccessful.demo.java8.lambda.tomap;

import iunsuccessful.demo.common.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 依韵 2021/3/4
 */
public class ToMapDemo {

    public static void main(String[] args) {
        duplicateKey();
    }

    /**
     * 看看重复 key 会不会报错
     */
    public static void duplicateKey() {
        Point point = new Point(2, 4);
        Point point1 = new Point(2, 1);
        Point point2 = new Point(3, 3);
        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point1);
        points.add(point2);
        Map<Integer, Integer> map = points.stream().distinct().collect(Collectors.toMap(Point::getX, Point::getY));
        map.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println(integer + " " + integer);
            }
        });

    }

}
