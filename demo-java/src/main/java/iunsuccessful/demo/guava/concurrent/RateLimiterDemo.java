package iunsuccessful.demo.guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create By LiQZ 2018/7/5
 */
public class RateLimiterDemo {



    public static void main(String[] args){

        //新建一个每秒限制3个的令牌桶
        RateLimiter rateLimiter = RateLimiter.create(20.0);

        final Semaphore semp = new Semaphore(20);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //获取令牌桶中一个令牌，最多等待10秒
//                    rateLimiter.acquire();
//                    if (rateLimiter.tryAcquire(1, 10, TimeUnit.SECONDS)) {
//                        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//                    }
                    try {
                        semp.acquire();
                        System.out.println(new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));
                        Thread.sleep(1000);
                        semp.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        executor.shutdown();

    }

}
