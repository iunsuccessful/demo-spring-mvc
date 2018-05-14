package iunsuccessful.demo.java8.lambda.staring_stream;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * π/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
 * @author LiQZ on 2016/5/9.
 */
class PiSupplier implements Supplier<Double> {

    double sum = 0.0;
    double current = 1.0;
    boolean sign = true;

    @Override
    public Double get() {
        sum += (sign ? 4 : -4) / this.current;
        this.current = this.current + 2.0; // 1 3 5 7...
        this.sign = ! this.sign; // + / -
        return sum;
    }
}

/**
 * 利用欧拉变换对级数进行加速
 */
class EulerTransform implements Function<Double, Double> {

    double n1 = 0.0;
    double n2 = 0.0;
    double n3 = 0.0;

    @Override
    public Double apply(Double t) {
        System.out.println("in " + t);
        n1 = n2;
        n2 = n3;
        n3 = t;
        if (n1 == 0.0) {
            System.out.println("out " + t);
            return t;
        }
        double result = calc();
        System.out.println("out " + result);
        return result;
    }

    double calc() {
        double d = n3 - n2;
        return n3 - d * d / (n1 - 2 * n2 + n3);
    }
}


public class PiStream {

    public static void main(String[] args) {
        Stream<Double> piStream = Stream.generate(new PiSupplier());
        piStream.map(new EulerTransform())
                .skip(5).limit(1).forEach(System.out::println);
    }
}
