package iunsuccessful.demo.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal 直接除，如果除不尽，会抛出 ArithmeticException
 * 依韵 2022/6/11
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        // Non-terminating decimal expansion; no exact representable decimal result.
        BigDecimal a = new BigDecimal("15.1");
        BigDecimal b = new BigDecimal("3");
        // System.out.println(a.divide(b));
        // 解决方案
        System.out.println(a.divide(b, 6, RoundingMode.HALF_UP));


    }

}
