package iunsuccessful.demo.vavr;

import io.vavr.Function2;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import iunsuccessful.demo.common.domain.Point;


/**
 * 依韵 2021/12/26
 */
public class ListDemo {

    public static void main(String[] args) {
        List<Point> points = List.of(
                new Point(1, 1),
                new Point(3, 2),
                new Point(3, 3),
                new Point(2, 2),
                new Point(2, 2),
                new Point(2, 4),
                new Point(4, 1)

        );
        // java8 的写法
        // Map<Integer, List<Point>> pointMap = points.stream().collect(Collectors.groupingBy(Point::getX, LinkedHashMap::new, toList()));
        // HashMap((1, 1), (2, 4), (3, 3), (4, 4))
        Map<Integer, Integer> ab = points.toMap(Point::getX, Point::getY);
        System.out.println(ab);
        // 两步式
        Map<Integer, List<Point>> abc = points.groupBy(Point::getX);
        Map<Integer, List<Integer>> abcd = abc.bimap(x -> x, points1 -> points1.map(Point::getY));
        // 一步式
        Map<Integer, List<Integer>> abcde = points
                .groupBy(Point::getX)
                .bimap(x -> x, points1 -> points1.map(Point::getY).distinct());


        Map<Integer, List<Integer>> abcdeg = points
                .groupBy(Point::getX)
                .mapValues(points13 -> points13.map(Point::getY).distinct());


        System.out.println(abcd);
        System.out.println(abcde);
        System.out.println(abcdeg);
        // bimap 与这个的底层实现是一样的 Tuple.of(keyMapper.apply(entry._1), valueMapper.apply(entry._2))
        Map<Integer, List<Integer>> abcdef = abc.map((Function2<Integer, List<Point>, Tuple2<Integer, List<Integer>>>) (integer, points12) -> new Tuple2<>(integer, points12.map(Point::getY).distinct()));
        System.out.println(abcdef);

        // group reduce 的 java 8 就可以实现
        // orderDTO.getDetails().stream().collect(Collectors.groupingBy(OrderDetailDTO::getProductGuid, Collectors.summingInt(OrderDetailDTO::getNum)));

    }

}
