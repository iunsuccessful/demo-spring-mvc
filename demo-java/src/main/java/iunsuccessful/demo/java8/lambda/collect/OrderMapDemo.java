package iunsuccessful.demo.java8.lambda.collect;

import iunsuccessful.demo.common.domain.Point;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * 依韵 2020/7/28
 */
public class OrderMapDemo {

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(3, 3));
        points.add(new Point(2, 2));
        points.add(new Point(4, 4));
        Map<Integer, List<Point>> pointMap = points.stream().collect(Collectors.groupingBy(Point::getX, LinkedHashMap::new, toList()));
        PrintUtils.print(pointMap);

        Map<Integer, List<Point>> pointMap1 = points.stream().collect(Collectors.groupingBy(Point::getX));
    }

}
