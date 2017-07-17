package iunsuccessful.demo.java8.thread;

import java.util.concurrent.CompletableFuture;

/**
 * Java 8 方式的线程创建
 * Created by LiQZ on 2017/7/17.
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        createThread();
//        Thread.sleep(1000l);
    }

    private static void createThread() {
        System.out.println(Thread.currentThread().getName());
        // Modify java 8 method.
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }

}
