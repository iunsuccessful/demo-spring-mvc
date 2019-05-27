package iunsuccessful.demo.java8.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo2 {

    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(()->{return "Hello ";}).thenApplyAsync(v -> v + "world").join();

        // 等待其他线程同时完成
//        CompletableFuture.allOf().join();
        System.out.println(result);
    }

}
