package iunsuccessful.demo.base.number;

import java.math.BigDecimal;

/**
 * Created by LiQZ on 2016/12/5.
 */
public class BigDecimalDemo {

    /**
     * 判断 BigDecimal 中数字是否是两位
     */
    public static void main(String[] args) {
        BigDecimal discount = new BigDecimal(1.544);
        double first = discount.doubleValue();
        double second = discount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(first);
        System.out.println(second);
        System.out.println(first == second);
    }

}
