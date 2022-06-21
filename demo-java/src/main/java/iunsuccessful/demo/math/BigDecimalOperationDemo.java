package iunsuccessful.demo.math;

import java.math.BigDecimal;

/**
 * 依韵 2022/6/21
 */
public class BigDecimalOperationDemo {

    public static void main(String[] args) {
        BigDecimal result = BigDecimalOperation.PLUS.apply(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        System.out.println(result);
        result = BigDecimalOperation.DIVIDE.apply(BigDecimal.valueOf(10), BigDecimal.valueOf(3));
        System.out.println(result);
    }

}
