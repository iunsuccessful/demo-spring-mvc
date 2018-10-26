package iunsuccessful.demo.base.string;

import java.awt.*;

/**
 * Create By LiQZ 2018/7/12
 */
public class StringFormatDemo {

    public static void main(String[] args){
        int i = 16;
        System.out.printf("%d %s %s\n", i, Integer.toBinaryString(i), Integer.toBinaryString(-i));
        System.out.println( 3 + 3 + "" + 3 + 3);
    }

}
