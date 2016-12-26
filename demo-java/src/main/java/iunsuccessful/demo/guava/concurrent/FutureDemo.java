package iunsuccessful.demo.guava.concurrent;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static iunsuccessful.demo.common.utils.PrintUtils.print;

/**
 * @author LiQZ on 2016/6/7.
 */
public class FutureDemo {

    private static final ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());

    public static void main(String[] args) throws Exception {
        // normal();
//        line();
//        list();
//        list2();
//        runLog();
//        syncNotWaitResult();
        normalUse();
        service.shutdown();
        System.out.println("end");
    }

    /**
     * 正常使用
     */
    static void normal() {
        ListenableFuture explosion = service.submit(new Callable() {
            public Object call() {
                return 2 + 3;
            }
        });
        Futures.addCallback(explosion, new FutureCallback() {
            // we want this handler to run immediately after we push the big red button!
            public void onSuccess(Object explosion) {
//                walkAwayFrom(explosion);
                System.out.println("success " + explosion);
            }
            public void onFailure(Throwable thrown) {
//                battleArchNemesis(); // escaped the explosion!
            }
        });
    }

    /**
     * 链式回调（可以继续使用 transform 多重链式回调）
     */
    public static void line() {
        Function<String, String> queryFunction = new Function<String, String>() {
            public String apply(String DO) {
                System.out.println("find in redis");
                return String.format("%s -> BO", DO);
            }
        };
        ListenableFuture queryFuture = Futures.transform(findDB("condition"), queryFunction);
        try {
            System.out.println(queryFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static ListenableFuture<String> findDB(final String condition) {
        ListenableFuture<String> explosion = service.submit(new Callable() {
            public String call() {
                System.out.println("find in db");
                return String.format("find DB %s", condition);
            }
        });
        return explosion;
    }

    /**
     * 加载开启多线程，聚合 list
     */
    static void list() throws ExecutionException, InterruptedException {
        List<String> params = Lists.newArrayList();
        params.add("one");
        params.add("two");
        params.add("three");
        ExecutorService service = Executors.newFixedThreadPool(params.size());
        List<ListenableFuture<String>> futures = Lists.newArrayList();
        for (String param :params) {
            futures.add(findDB(param));
        }
        List<String> result = Lists.newArrayList();
        for (ListenableFuture<String> future :futures) {
            result.add(future.get());
        }
        print(result);
    }

    static void list2() throws Exception {
        List<String> params = Lists.newArrayList();
        params.add("one");
        params.add("two");
        params.add("three");
        ExecutorService service = Executors.newFixedThreadPool(params.size());
        List<ListenableFuture<String>> futures = Lists.newArrayList();
        for (String param :params) {
            futures.add(findDB(param));
        }
        List<String> result = Futures.successfulAsList(futures).get();
        print(result);
    }

    static void list3() {
        List<String> params = Lists.newArrayList();
        params.add("one");
        params.add("two");
        params.add("three");
        params.add("fore");
        params.add("five");
        params.add("six");
        params.add("seven");
        List<String> result = params.parallelStream().map(new java.util.function.Function<String, String>() {
            @Override
            public String apply(String s) {
                return convert(s);
            }
        }).collect(Collectors.toList());
        print(result);
    }

    static void runLog() {
        long begin = System.currentTimeMillis();
        list3();
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 一个耗时的转换，用来模拟查询数据库
     */
    static String convert(String input) {
        try {
            Thread.sleep(300l);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuilder revert = new StringBuilder();
        for (int i = input.length(); i < 1; i++ ) {
            revert.append(input.charAt(i-1));
        }
        return revert.toString();
    }

    static void syncNotWaitResult() throws Exception {
        final String condition = "syncNotWaitResult";
        ListenableFuture<String> explosion = service.submit(new Callable() {
            public String call() {
                System.out.println("find in db");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return String.format("find DB %s", condition);
            }
        });
//        Futures.transform(explosion, new Function<String, Object>() {
//            @Override
//            public Object apply(String input) {
//                System.out.println(input);
//                service.shutdown();
//                return null;
//            }
//        });
        System.out.println("###");
//        System.out.println(explosion.get());
    }

    static void normalUse() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("sync run.");
            }
        });
        service.shutdownNow();
    }

}
