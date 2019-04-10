package iunsuccessful.demo.java8.lambda.option;

import iunsuccessful.demo.java8.lambda.collector.points.Point;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/3 .
 */
public class OptionDemo3 {

    public static void main(String[] args) {
        Point point = new Point(1, 3);
        System.out.println(java.util.Optional.ofNullable(point).isPresent());
    }

}
