package iunsuccessful.demo.base.array;

/**
 * Created by LiQZ on 2017/10/16.
 */
public class ArrayDemo {

    public static void main(String[] args) {
//        int[][] arr = new int[9][10];

//        System.out.println(arr[8][9]);

        test();
    }

    /**
     * 下列二维数组声明正确的是：
     * A.int a[4][6];
     * B.int a[4][6] = new int[4][6];
     * C.int a[][] = new int[4][];
     * D.int a[][] = new int[][6];
     */
    public static void test() {
        int a[][] = new int[4][];
        for (int i = 0; i < a.length; i++) {
            // NullPointerException
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%d %d %d\n", i, j, a[i][j]);
            }
        }
    }

}
