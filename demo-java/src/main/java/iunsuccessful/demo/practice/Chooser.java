package iunsuccessful.demo.practice;

/**
 * @author LiQZ on 2016/9/22.
 */
public class Chooser {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++ ) {
//            System.out.printf("%d %10s %10s %s %s\n", i, Integer.toBinaryString(i),
//                    Integer.toBinaryString(-i),
//                    Integer.toBinaryString(i & -i),
//                    isPowerOfTwo(i));
            if (isPowerOfTwo(i)) {
                System.out.printf("%d %s %s\n", i, Integer.toBinaryString(i), Integer.toBinaryString(-i));
            }
        }
    }


    /**
     * 判断children长度是否为2的幂
     */
    private static boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }

}
