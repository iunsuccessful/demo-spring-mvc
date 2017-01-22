package iunsuccessful.demo.java8.thread;

import iunsuccessful.demo.common.utils.MiscUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * Created by LiQZ on 2017/1/22.
 */
public class RunDemo {

    private static final Logger logger = LoggerFactory.getLogger(RunDemo.class);

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> {
            logger.debug("Inside Thread name: {}", Thread.currentThread().getName());
        });
        logger.debug("Outside Thread name: {}", Thread.currentThread().getName());
        MiscUtils.sleep(1000);
    }

}
