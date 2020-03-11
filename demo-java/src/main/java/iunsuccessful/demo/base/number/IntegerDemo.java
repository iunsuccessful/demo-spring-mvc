package iunsuccessful.demo.base.number;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by LiQZ on 2017/11/18.
 */
public class IntegerDemo {

    public static void main(String[] args) {
        try {
            if (NumberUtils.isNumber("13601130005")) {
                new Integer("13601130005");
            }
        } catch (Exception e) {

        }
    }

    public static boolean batchInteger(Integer a, Integer b) {
        int remainder = a % b;
        return remainder == 0;
    }

}
