package iunsuccessful.demo.base.operation;

import java.math.BigDecimal;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/19 .
 */
public class CompareDemo {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(20);
        BigDecimal b = new BigDecimal(10);
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(b) == 1);

        Integer ai = new Integer(20);
        Integer bi = new Integer(10);
        System.out.println(ai.compareTo(bi));
        System.out.println(ai.compareTo(bi) == 1);

    }

}
