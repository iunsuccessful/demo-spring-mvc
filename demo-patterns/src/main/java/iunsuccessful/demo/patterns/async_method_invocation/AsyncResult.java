package iunsuccessful.demo.patterns.async_method_invocation;

import java.util.concurrent.ExecutionException;

/**
 * 返回结果
 * @author LiQZ on 2016/9/30.
 */
public interface AsyncResult<T> {

    boolean isCompleted();

    T getValue() throws ExecutionException;

    void await() throws InterruptedException;

}
