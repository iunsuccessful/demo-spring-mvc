package iunsuccessful.demo.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Predicate<T>——接收T对象并返回boolean
 * Consumer<T>——接收T对象，不返回值
 * Supplier<T>——提供T对象（例如工厂），不接收值
 * Function<T, R>——接收T对象，返回R对象
 * Function -> UnaryOperator<T>——接收T对象，返回T对象
 * @author LiQZ on 2016/5/9.
 */
public class UnaryOperatorDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,20,30,40,50);

        list.stream().map(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        }).forEach(System.out::println);

    }

}
