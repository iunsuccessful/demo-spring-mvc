package iunsuccessful.demo.java8.lambda;

import java.util.function.Function;

/**
 * N!
 * Created by LiQZ on 2016/12/2.
 */
public class FactorialDemo {

    public static void main(String[] args) {
        method1(10);
        method2(10);
    }

    static void method1(int i) {
        Function<Integer, Integer> fun = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                if (integer == 1) {
                    return 1;
                }
                return integer * this.apply(integer - 1);
            }
        };
        System.out.println(fun.apply(i));
    }

    static void method2(Integer i) {
        // 错误示范
//        Function<Integer, Integer> factorial = i -> { return i == 0 ? 1 : i * factorial.apply( i - 1 ); };
        // 正确用法
        System.out.println(new Factorial().factorial.apply(i));

    }

}

class Factorial {

    Function<Integer, Integer> factorial = null;

    public Factorial() {
        factorial = i -> i == 0 ? 1 : i * factorial.apply( i - 1 );
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().factorial.apply(10));
    }
}
