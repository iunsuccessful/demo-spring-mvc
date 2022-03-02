package iunsuccessful.demo.java8.lambda.grouping;

import iunsuccessful.demo.common.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 依韵 2021/11/25
 */
public class GroupingDemo2 {

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(1, 3));
        points.add(new Point(2, 3));

        points.stream().collect(Collectors.groupingBy(Point::getX, Collectors.toList()));


    }

}
