package iunsuccessful.demo.java8.lambda.map_peek;

import com.google.common.collect.Lists;
import iunsuccessful.demo.common.domain.Point;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 依韵 2020/5/22
 */
public class MapPeekDemo {

    public static void main(String[] args) {
        List<Point> pointList = Lists.newArrayList(new Point(1, 3), new Point(2, 4), new Point(2, 4));
        List<Point> x = pointList.stream()
                .peek(point -> point.setX(10))
                .collect(Collectors.toList());
        // peek 等于下面这个，就是中途操作了一下变化 ，但原来状态不变
        List<Point> y = pointList.stream().map(new Function<Point, Point>() {
            @Override
            public Point apply(Point point) {
                point.setX(10);
                return point;
            }
        }).collect(Collectors.toList());
        PrintUtils.print(x);
    }

}
