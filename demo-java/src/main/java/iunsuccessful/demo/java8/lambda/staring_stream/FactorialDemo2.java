package iunsuccessful.demo.java8.lambda.staring_stream;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * 斐波那契数列
 * Created by LiQZ on 2016/12/5.
 */
public class FactorialDemo2 {

    private static long NUMBER = 1000;

    public static void main(String[] args) {

        Tuple<BigInteger, BigInteger> seed = new Tuple<>(BigInteger.ONE, BigInteger.ONE);

        UnaryOperator<Tuple<BigInteger, BigInteger>> f = x -> new Tuple<>(x._2, x._1.add(x._2));

//        Stream.generate()
//        Stream.iterate()
        Stream<BigInteger> fiboStream = Stream.iterate(seed, f)
                .map(x -> x._1)
                .limit(NUMBER);

        System.out.println(fiboStream.skip(NUMBER -1).findFirst().get());

    }

}

// 元组
class Tuple<T, U> {
    public final T _1;
    public final U _2;
    public Tuple(T t, U u) {
        this._1 = t;
        this._2 = u;
    }
}
