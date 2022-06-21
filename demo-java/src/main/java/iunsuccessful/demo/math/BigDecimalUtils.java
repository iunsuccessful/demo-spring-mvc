package iunsuccessful.demo.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 依韵 2022/6/14
 */
public class BigDecimalUtils {

    /**
     * 除法
     */
    public static Double divide(Double v1, Double v2) {
        return divide(v1, v2, 2);
    }

    /**
     *
     * 除法
     */
    public static Double divide(Double v1, Double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return divide(b1, b2, scale).doubleValue();
    }

    public static BigDecimal divide(BigDecimal v1, BigDecimal v2) {
        return v1.divide(v2, 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide(BigDecimal v1, BigDecimal v2, int scale) {
        return v1.divide(v2, scale, RoundingMode.HALF_UP);
    }


    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        return v1.add(v2);
    }

    /**
     * >=
     */
    public static boolean gte(BigDecimal a, BigDecimal b) {
        // a >= b
        return a.compareTo(b) >= 0;
    }

    public static BigDecimal max(BigDecimal a, BigDecimal b) {
        // a >= b
        return gte(a, b) ? a : b;
    }

    public static BigDecimal min(BigDecimal a, BigDecimal b) {
        // a >= b
        return gte(a, b) ? b : a;
    }

    public static boolean gt(BigDecimal a, BigDecimal b) {
        // a > b
        return a.compareTo(b) > 0;
    }

    /**
     * <=
     */
    public static boolean lte(BigDecimal a, BigDecimal b) {
        // a <= b
        return a.compareTo(b) <= 0;
    }

    public static boolean lt(BigDecimal a, BigDecimal b) {
        // a <= b
        return a.compareTo(b) < 0;
    }



}
