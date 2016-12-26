package iunsuccessful.demo.java8.lambda.consumer;

import java.util.function.Consumer;

/**
 * @author LiQZ on 2016/9/30.
 */
public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("hello");
    }

}
