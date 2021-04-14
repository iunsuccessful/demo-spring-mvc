package iunsuccessful.demo.java8.lambda.option;

import java.util.Optional;
import java.util.function.Function;

/**
 * 依韵 2020/12/14
 */
public class OptionalEmptyDemo {

    public static void main(String[] args) {
        Object s = Optional.empty().map(new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                System.out.println("111");
                return null;
            }
        }).orElse(2);
        System.out.println(s);
    }

}
