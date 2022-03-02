package iunsuccessful.demo.base.string;

/**
 * 依韵 2021/8/14
 */
public class JinZhiDemo {

    public static void main(String[] args) {
        System.out.println(change("999999999999999999999"));
    }

    public static String change(String num) {
        int f=10;
        int t=32;
        return new java.math.BigInteger(num, f).toString(t);
    }

}
