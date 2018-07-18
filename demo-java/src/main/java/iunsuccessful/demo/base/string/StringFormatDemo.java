package iunsuccessful.demo.base.string;

/**
 * Create By LiQZ 2018/7/12
 */
public class StringFormatDemo {

    public static void main(String[] args){
        int i = 16;
        System.out.printf("%d %s %s\n", i, Integer.toBinaryString(i), Integer.toBinaryString(-i));
    }

}
