package iunsuccessful.demo.base.future;

import com.google.common.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * @author LiQZ on 2016/3/22.
 */
public class ListenableFutureDemo {

    public static final Logger logger = LoggerFactory.getLogger(ListenableFutureDemo.class);

    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
        ListenableFuture explosion = service.submit(new Callable() {
            public String call() throws Exception {
                logger.info("call run!");
                Thread.sleep(1000 * 5);
                return "call";
            }
        });

        Futures.addCallback(explosion, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                logger.info("{} success!", result);
                service.shutdown();
            }

            @Override
            public void onFailure(Throwable t) {
                logger.info("{} failure!", t);
                service.shutdown();
            }
        });

    }

}
