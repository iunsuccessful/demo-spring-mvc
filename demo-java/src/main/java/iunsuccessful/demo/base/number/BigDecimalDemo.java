package iunsuccessful.demo.base.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by LiQZ on 2016/12/5.
 */
public class BigDecimalDemo {

    /**
     * 判断 BigDecimal 中数字是否是两位
     */
    public static void main(String[] args) {
//        BigDecimal discount = new BigDecimal(1.544001);
//        double first = discount.doubleValue();
//        double second = discount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(first);
//        System.out.println(second);
//        System.out.println(first == second);
        format();
    }

    public static void format() {
//        DecimalFormat df = new DecimalFormat("#.##");
//        System.out.println(df.format(Double.valueOf("18260081109")));
//        System.out.println(df.format(Double.valueOf("100.2")));

        BigDecimal a = new BigDecimal(3);
        BigDecimal b = new BigDecimal(2);

        System.out.println(a.add(b).hashCode());
        System.out.println(a.hashCode());

    }

}
