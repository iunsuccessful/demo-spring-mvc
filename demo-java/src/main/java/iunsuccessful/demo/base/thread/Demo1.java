package iunsuccessful.demo.base.thread;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Create By LiQZ 2018/6/5
 */
public class Demo1 {



    public static void main(String[] args) throws InterruptedException {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("cache-reload-pool-%d").setDaemon(true).build();
        ExecutorService parentExecutor = Executors.newSingleThreadExecutor(threadFactory);
        final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(parentExecutor);

        executorService.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("test");
                return "test2";
            }
        });


        Thread.sleep(300000l);

    }

}
