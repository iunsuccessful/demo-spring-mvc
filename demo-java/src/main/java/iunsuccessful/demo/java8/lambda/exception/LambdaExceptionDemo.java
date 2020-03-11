package iunsuccessful.demo.java8.lambda.exception;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 依韵 2019-06-11
 */
public class LambdaExceptionDemo {

    public static void main(String[] args) {


        LambdaExceptionDemo lambdaExceptionDemo = new LambdaExceptionDemo();
        lambdaExceptionDemo.test0();

    }

    private void test0() {
        try {
            test1();
        } catch (Exception e) {
            System.out.println("exception");
        }
    }

    private void test1() {
        List<Integer> test = Arrays.asList(1, 2);
        test.forEach(integer -> {
            if (integer == 1) {
                throw new RuntimeException("Text");
            }
        });
        System.out.println("test 1 end");
    }

}
