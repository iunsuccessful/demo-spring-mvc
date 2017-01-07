package iunsuccessful.demo.java8.lambda.collector.model.chapter_4_3;

/**
 * Created by Anonymous on 1/7/2017.
 */
public class Point {


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
