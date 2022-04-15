package iunsuccessful.demo.java8.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureDemo {

    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("consumer-queue-thread-%d").build();

    ExecutorService singleThreadExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(1),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());

    private void run() {

        List<Integer> lines = Arrays.asList(1, 2, 3);

//        CompletableFuture[] cfs = lines.stream().map(t -> CompletableFuture.supplyAsync(() -> {
//            System.out.println("Test");
//            return 0;
//        }, singleThreadExecutor)).toArray(CompletableFuture[]::new);

        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("###1");
            return 0;
        }, singleThreadExecutor);

        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("###2");
        }, singleThreadExecutor);

//        // singleThreadExecutor.submit 修改不了
//        ForkJoinPool forkJoinPool = new ForkJoinPool(1);
//        forkJoinPool.submit(() -> {
//            lines.parallelStream().forEach(integer -> System.out.printf("ps %s\n", Thread.currentThread().getName()));
//        });
//
//        cf.thenApplyAsync(v -> v + "world").join();

//        System.out.println(singleThreadExecutor.);

//        CompletableFuture.allOf(cfs).join();

//        for (CompletableFuture cf : cfs) {
//            System.out.println(cf.isDone());
//            System.out.println(cf.get());
//        }

        System.out.println("END");

//        singleThreadExecutor.shutdownNow();

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        completableFutureDemo.run();
        Thread.sleep(1000);

    }



}
