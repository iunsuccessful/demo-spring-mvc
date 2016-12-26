package iunsuccessful.demo.patterns.common;

import java.util.concurrent.Callable;

/**
 * @author LiQZ on 2016/10/8.
 */
public class DataUtils {

    /**
     * Creates a callable that lazily evaluates to given value with artificial delay.
     * <code>
     return new Callable<T>() {
    @Override
    public T call() throws Exception {
    Thread.sleep(delayMillis);
    log("Task completed with: " + value);
    return value;
    }
    };
     * </code>
     * @param value
     *          value to evaluate
     * @param delayMillis
     *          artificial delay in milliseconds
     * @return new callable for lazy evaluation
     */
    public static <T> Callable<T> lazyval(T value, long delayMillis) {
        return () -> {
            Thread.sleep(delayMillis);
            log("Task completed with: " + value);
            return value;
        };
    }

    public static void log(String msg) {
        System.out.println(String.format("[%1$-10s] - %2$s", Thread.currentThread().getName(), msg));
    }

}
