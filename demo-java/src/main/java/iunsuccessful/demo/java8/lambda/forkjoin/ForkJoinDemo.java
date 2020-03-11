package iunsuccessful.demo.java8.lambda.forkjoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * 依韵 2020/3/3
 */
public class ForkJoinDemo {

    private static final Logger logger = LoggerFactory.getLogger(ForkJoinDemo.class);

    public static void main(String[] args) {

        List<Integer> firstRange = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> secondRange = Arrays.asList(1, 2, 3, 4, 5);

//        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
//        forkJoinPool.submit(() -> {
            firstRange.parallelStream().forEach((number) -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(5);
                } catch (InterruptedException e) { }
            });
//        });

//        ForkJoinPool forkJoinPool2 = new ForkJoinPool(3);
//        forkJoinPool2.submit(() -> {
            secondRange.parallelStream().forEach((number) -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
            });
//        });

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
