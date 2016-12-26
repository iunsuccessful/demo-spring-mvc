package iunsuccessful.demo.patterns.async_method_invocation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author LiQZ on 2016/9/30.
 */
public interface AsyncExecutor {

    <T> AsyncResult<T> start(Callable<T> callable);

    <T> AsyncResult<T> start(Callable<T> callable, AsyncCallback<T> callback);

    <T> T get(AsyncResult<T> result) throws ExecutionException, InterruptedException;

}
