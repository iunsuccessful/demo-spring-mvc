package iunsuccessful.demo.base.future.demo;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.DoubleStream;

/**
 * @author LiQZ on 2016/6/12.
 */
public class Client {

    private static final Random rand = new Random();
    private static final int MIN = 1;
    private static final int MAX = 140;
    private static final int POPULATION_SIZE = 30_000_000;

    public static void main(String[] args) {
        double[] population = DoubleStream.generate(Client::randInt).limit(POPULATION_SIZE).toArray();
        System.out.println(population.length);
        measurePerf(Client::varianceImperative, population);
        measurePerf(ForkJoinCalculator::varianceForkJoin, population);
        measurePerf(Client::varianceStreams, population);
    }

    public static <T, R> void measurePerf(Function<T, R> f, T input) {
        long start = System.currentTimeMillis();
        R result = f.apply(input);
        System.out.println(String.format("cost %4d result %f", System.currentTimeMillis() - start, result));
    }

    public static int randInt() {
        return rand.nextInt((MAX - MIN) + 1) + MIN;
    }

    public static double varianceImperative(double[] population){
        double average = 0.0;

        for(double p: population){
            average += p;
        }

        average /= population.length;

        double variance = 0.0;

        for(double p: population){
            variance += (p - average) * (p - average);
        }

        return variance/population.length;
    }

    public static double varianceStreams(double[] population){
        final double average = Arrays.stream(population).parallel().average().orElse(0.0);
        double variance = Arrays.stream(population).parallel()
                .map(p -> (p - average) * (p - average))
                .average().orElse(0.0);
        return variance;
    }

}
