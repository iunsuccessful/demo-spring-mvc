package iunsuccessful.demo.java8.lambda;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by LiQZ on 2016/12/5.
 */
public class Demo {

    private static long number = 1000;

    public static void main(String[] args) {
        Tuple<BigInteger, BigInteger> seed = new Tuple<>(BigInteger.ONE, BigInteger.ONE);
        UnaryOperator<Tuple<BigInteger, BigInteger>> f = x -> new Tuple<>(x._2, x._1.add(x._2));
        Stream<BigInteger> fiboStream = Stream.iterate(seed, f)
                .map(x -> x._1)
                .limit(number);

        System.out.println(fiboStream.skip(number -1).findFirst().get());

    }

}

class Tuple<T, U> {
    public final T _1;
    public final U _2;
    public Tuple(T t, U u) {
        this._1 = t;
        this._2 = u;
    }
}
