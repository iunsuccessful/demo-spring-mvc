package iunsuccessful.demo.base;

/**
 * 依韵 2020/1/9
 */
public class BoolDemo {

    public static void main(String[] args) {
        // &
        if (test1() & test2()) {

        }
        // &&
        if (test1() && test2()) {

        }

    }

    private static boolean test1() {
        System.out.println("test1");
        return false;
    }

    private static  boolean test2() {
        System.out.println("test2");
        return false;
    }

}
