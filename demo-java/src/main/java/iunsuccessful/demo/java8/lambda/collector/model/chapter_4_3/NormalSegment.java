package iunsuccessful.demo.java8.lambda.collector.model.chapter_4_3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 分段的普通写法
 * <pre>
 *     以 MAX_DISTANCE 为距离分段
 * </pre>
 * Created by Anonymous on 1/7/2017.
 */
public class NormalSegment {

    protected static double MAX_DISTANCE = 2.0;

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(3, 0), new Point(6, 0), new Point(8,0), new Point(10, 0), new Point(14,0));
        Deque<Deque<Point>> segmentPoints = groupByProximity(points);
        System.out.println(segmentPoints);
    }

    private static Deque<Deque<Point>> groupByProximity(List<Point> sortedPointList) {
        Deque<Deque<Point>> points = new ArrayDeque<>();
        points.add(new ArrayDeque<>());
        for (Point p: sortedPointList) {
            Deque<Point> lastSegment = points.getLast();
            if (!lastSegment.isEmpty() && lastSegment.getLast().distance(p) > MAX_DISTANCE) {
                Deque<Point> newSegment = new ArrayDeque<>();
                newSegment.add(p);
                points.add(newSegment);
            } else {
                lastSegment.add(p);
            }

        }
        return points;
    }

}
