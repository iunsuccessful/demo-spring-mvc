package iunsuccessful.demo.java8.stream;

import java.util.stream.Stream;

/**
 * 依韵 2022/5/5
 */
public class ReduceDemo {

     public static void main(String[] args) {
//        reduce1();
        reduce2();
//        reduce3();
     }

     public static void reduce1() {
         String temp = Stream.of("a", "b", "c").reduce((a, b) -> {
             return a + "_" + b;
         }).get();

         System.out.println(temp);
     }

     public static void reduce2() {
         // normal 0_a_b_c
         // parallel 0_a_0_b_0_c
         String result = Stream.of("a", "b", "c").reduce("0", (a, b) -> {
             return a + "_" + b;
         });
         System.out.println(result);
     }

    /**
     * 第三个参数，在并行模式中，才起作用
     */
    public static void reduce3() {
        // normal 0_a_b_c
        // parallel 0_a*0_b*0_c
         String result = Stream.of("a", "b", "c").parallel().reduce("0", (a, b) -> a + "_" + b, (s, s2) -> s + "*" + s2);
         System.out.println(result);
     }

}
