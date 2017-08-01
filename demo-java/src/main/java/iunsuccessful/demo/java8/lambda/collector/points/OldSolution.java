package iunsuccessful.demo.java8.lambda.collector.points;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 原始方案
 * Created by LiQZ on 2017/7/19.
 */
public class OldSolution {

    public static void main(String[] args) {
        Deque<Deque<Point>> points = groupByProximity(Data.getSortedPointList());
        PrintUtils.print(points);
    }

    private static Deque<Deque<Point>> groupByProximity(List<Point> sortedPointList) {
        Deque<Deque<Point>> points = new ArrayDeque<>();
        points.add(new ArrayDeque<>());
        for (Point point: sortedPointList) {
            Deque<Point> deque = points.getLast();
            if (deque.isEmpty() || point.distance(deque.getLast()) <= Data.MAX_DISTANCE) {
                deque.add(point);
            } else {
                points.add(new ArrayDeque<>());
                points.getLast().add(point);
            }
        }
        return points;
    }


}
