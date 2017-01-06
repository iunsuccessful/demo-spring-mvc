package iunsuccessful.demo.java8.lambda.collector;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Chapter 4.3 自定义终结流
 * Created by LiQZ on 2017/1/6.
 */
public class Chapter4_3Demo {

    private static double MAX_DISTANCE = 2.0;

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


    static class Point {

        private double x;

        private double y;

        public Point(double x) {
            this.x = x;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double distance(Point point) {
            return Math.sqrt(Math.pow((x - point.x), 2)  + Math.pow((y - point.y), 2));
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
