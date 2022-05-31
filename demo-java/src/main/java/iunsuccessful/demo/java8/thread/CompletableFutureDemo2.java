package iunsuccessful.demo.java8.thread;

import java.util.concurrent.CompletableFuture;

/**
 * 如果没有 exceptionallyAsync 方法，是直接抛出异常的。
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) {
        String result = CompletableFuture
                .supplyAsync(()->{ exception(); return "Hello ";})
                .thenApplyAsync(v -> v + "world")
                .exceptionallyAsync(e -> "Error: " + e.getMessage())
                .join();

        // 等待其他线程同时完成
//        CompletableFuture.allOf().join();
        System.out.println(result);
    }

    /**
     * 执行异常
     */
    public static void exception() {
        System.out.println("exception");
        throw new RuntimeException("exception");
    }

}
