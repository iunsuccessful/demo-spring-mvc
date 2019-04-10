package iunsuccessful.demo.java8.lambda.collect;

import iunsuccessful.demo.common.domain.Point;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create By LiQZ 2018/11/29
 */
public class DuplicateKeyMapDemo {

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(2, 3));
        points.add(new Point(3, 4));
        points.add(new Point(4, 5));
        points.add(new Point(4, 7));
        // 相关 key 报错
        Map<Integer, Integer> map = points.stream().collect(Collectors.toMap(Point::getX, Point::getY));
        PrintUtils.print(map);
    }

}
