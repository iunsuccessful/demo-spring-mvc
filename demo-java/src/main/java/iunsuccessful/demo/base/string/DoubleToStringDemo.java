package iunsuccessful.demo.base.string;

/**
 * 依韵 2021/9/9
 */
public class DoubleToStringDemo {

    public static void main(String[] args) {
        System.out.println(String.format("%.2f", Double.valueOf(10)));
        System.out.println(String.format("%.2f", 10.1));
        System.out.println(String.format("%.2f", 10.11));
        System.out.println(String.format("%.2f", 10.1111));
    }

}
