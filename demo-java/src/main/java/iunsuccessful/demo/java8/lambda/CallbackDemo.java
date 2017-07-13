package iunsuccessful.demo.java8.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Created by LiQZ on 2017/5/12.
 */
public class CallbackDemo {

    public static void main(String[] args) throws InterruptedException {
        // 异步调用运程方法，结束后数据写入数据库
        asyncCall(new Callable<String>() { // <- 这个是请求方法
            @Override
            public String call() throws Exception {
                // TODO 向远程发送请求
                return "请求结果";
            }
        }, new Consumer<String>() { // <- 这个是回调方法
            @Override
            public void accept(String s) {
                System.out.println(s + "写入数据库");
            }
        });
        Thread.sleep(1000l);
    }


    private static  <T> void asyncCall(Callable<T> callable, Consumer<T> callback) {
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                // TODO 远程调用获取结果 result
                try {
                    T result = callable.call();
                    callback.accept(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
