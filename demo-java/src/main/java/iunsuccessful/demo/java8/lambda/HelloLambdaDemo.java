package iunsuccessful.demo.java8.lambda;

import java.util.function.IntUnaryOperator;

/**
 * Created by LiQZ on 2017/3/7.
 */
public class HelloLambdaDemo {

    int k = 0;

    // 正确的
    IntUnaryOperator iuo = k -> { int j = 3; return k + j; };

    // 可以引用到对象属性
    IntUnaryOperator iuo2 = q -> { int j = 3; return k + j; };

    public static void main(String[] args) {
        /** lambda 是什么 */
        // iunsuccessful.demo.java8.lambda.HelloLambdaDemo$$Lambda$1/140435067@1be6f5c3
        Runnable r = () -> {};
        System.out.println(r);


        /** 局部变量无法覆盖，对象属性可以覆盖 */

        // 错误的
        int i = 0;
//        r = () -> { int i = 3; };

        // 正确的
        IntUnaryOperator iuo = k -> { int j = 3; return k + j; };




    }

}
