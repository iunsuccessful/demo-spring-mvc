package iunsuccessful.demo.interview.alibaba;

import java.util.Arrays;

/**
 * Create By LiQZ 2018/7/8
 */
public class Demo2 {

    public static void main(String[] args){
        int b = 12345;
        int len = (b+"").length();
      int[] a = new int[len];
      int c = b;
      for (int i = len-1; i >= 0; i-- ) {
        a[i] = c%10;
        c = c/10;
      }
      int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * Math.pow(10, i);
        }
        System.out.println(sum);
    }

}
