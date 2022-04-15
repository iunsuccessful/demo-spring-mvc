package iunsuccessful.demo.vavr;

import java.util.function.Function;

/**
 * 依韵 2022/4/13
 */
public class Try2Demo {

     public static void main(String[] args) {
         int x = 1; int y = 2;
         Integer z = Try2.of(() -> { return x + y; }).get();
         System.out.println(z);
         Try2<Integer> r = Try2.of(integer -> integer + 1, 2);
         System.out.println(r.get());

     }

}
