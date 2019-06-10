package iunsuccessful.demo.java8.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

public class CompletableFutureDemo {

    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("consumer-queue-thread-%d").build();

    ExecutorService singleThreadExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(1),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());

    private void run() {

        List<Integer> lines = Arrays.asList(1, 2, 3);

//        CompletableFuture[] cfs = lines.stream().map(t -> CompletableFuture.supplyAsync(() -> {
//            System.out.println("Test");
//            return 0;
//        }, singleThreadExecutor)).toArray(CompletableFuture[]::new);

        CompletableFuture cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("Test");
            return 0;
        }, singleThreadExecutor);

        cf.thenApplyAsync(v -> v + "world").join();

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

    }



}
