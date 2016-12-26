package iunsuccessful.demo.base.future.demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author LiQZ on 2016/6/12.
 */
public class ForkJoinCalculator extends RecursiveTask<Double> {

    public static final long THRESHOLD = 1_000_000;

    private final SequentialCalculator sequentialCalculator;
    private final double[] numbers;
    private final int start;
    private final int end;

    public ForkJoinCalculator(double[] numbers, SequentialCalculator sequentialCalculator) {
        this(numbers, 0, numbers.length, sequentialCalculator);
    }

    private ForkJoinCalculator(double[] numbers, int start, int end, SequentialCalculator
            sequentialCalculator) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.sequentialCalculator = sequentialCalculator;
    }

    @Override
    protected Double compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return sequentialCalculator.computeSequentially(numbers, start, end);
        }
        ForkJoinCalculator leftTask = new ForkJoinCalculator(numbers, start, start + length/2, sequentialCalculator);
        leftTask.fork();
        ForkJoinCalculator rightTask = new ForkJoinCalculator(numbers, start + length/2, end, sequentialCalculator);
        Double rightResult = rightTask.compute();
        Double leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    public static double varianceForkJoin(double[] population){
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        double total = forkJoinPool.invoke(new ForkJoinCalculator(population, new SequentialCalculator() {
                    @Override
                    public double computeSequentially(double[] numbers, int start, int end) {
                        double total = 0;
                        for (int i = start; i < end; i++) {
                            total += numbers[i];
                        }
                        return total;
                    }
                }));

        final double average = total / population.length;

        double variance = forkJoinPool.invoke(new ForkJoinCalculator(population, new SequentialCalculator() {
                    @Override
                    public double computeSequentially(double[] numbers, int start, int end) {
                        double variance = 0;
                        for (int i = start; i < end; i++) {
                            variance += (numbers[i] - average) * (numbers[i] - average);
                        }
                        return variance;
                    }
                }));
        return variance / population.length;
    }
}
