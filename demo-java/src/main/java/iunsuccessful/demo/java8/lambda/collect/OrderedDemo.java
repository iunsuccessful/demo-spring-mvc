package iunsuccessful.demo.java8.lambda.collect;

import iunsuccessful.demo.common.domain.Point;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 依韵 2022/3/11
 */
public class OrderedDemo {

    public static void main(String[] args) {

        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 10));
        points.add(new Point(3, 10));
        points.add(new Point(8, 10));
        points.add(new Point(7, 10));
        points.add(new Point(3, 10));
        points.add(new Point(11, 10));
        points.add(new Point(6, 10));

        PrintUtils.print(points);

        System.out.println("#############");

        points.stream().map(Point::getX).distinct().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer s) {
                System.out.println(s);
            }
        });

    }

}
