package iunsuccessful.demo.java8.lambda.collector.points;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiQZ on 2017/7/19.
 */
public class Data {

    static int MAX_DISTANCE = 2;

    static List<Point> getSortedPointList() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(3, 0));
        points.add(new Point(6, 0));
        points.add(new Point(8, 0));
        points.add(new Point(10, 0));
        points.add(new Point(14, 0));
        return points;
    }

}
