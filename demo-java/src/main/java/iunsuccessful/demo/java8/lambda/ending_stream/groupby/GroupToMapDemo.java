package iunsuccessful.demo.java8.lambda.ending_stream.groupby;

import com.google.common.base.MoreObjects;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Create By LiQZ 2018/7/15
 */
public class GroupToMapDemo {

    /**
     * List 转换成 map x, 相同的分一组
     * @param args
     */
    public static void main(String[] args){

        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 3));
        points.add(new Point(1, 4));
        points.add(new Point(1, 5));
        points.add(new Point(1, 6));
        points.add(new Point(2, 1));
        points.add(new Point(2, 2));

        Map<Integer, List<Point>> result = points.stream().collect(groupingBy(Point::getX, toList()));

        PrintUtils.print(result);

    }



}

class Point {

    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("x", x)
                .add("y", y)
                .toString();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
