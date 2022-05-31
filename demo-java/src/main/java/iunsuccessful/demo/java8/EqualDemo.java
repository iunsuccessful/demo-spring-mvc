package iunsuccessful.demo.java8;

import java.util.Objects;

/**
 * 依韵 2022/4/29
 */
public class EqualDemo {

    public static void main(String[] args) {
        Long a = 123L;
        System.out.println(Objects.equals(a, 123L));
        long b = 123L;
        // System.out.println(b instanceof Long);
    }

}
