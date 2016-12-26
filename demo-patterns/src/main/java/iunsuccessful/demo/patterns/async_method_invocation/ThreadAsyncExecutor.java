package iunsuccessful.demo.patterns.async_method_invocation;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author LiQZ on 2016/9/30.
 */
public class ThreadAsyncExecutor implements AsyncExecutor {

    @Override
    public <T> AsyncResult<T> start(Callable<T> callable) {
        return start(callable, null);
    }

    @Override
    public <T> AsyncResult<T> start(Callable<T> callable, AsyncCallback<T> callback) {
        CompletableAsyncResult<T> result = new CompletableAsyncResult<>(callback);

        // Modify java 8 method.
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    result.setValue(callable.call());
                } catch (Exception ex) {
                    result.setException(ex);
                }
            }
        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    result.setValue(callable.call());
//                } catch (Exception e) {
//                    result.setException(e);
//                }
//            }
//        }).start();
        return result;
    }

    @Override
    public <T> T get(AsyncResult<T> result) throws ExecutionException, InterruptedException {
        if (!result.isCompleted()) {
            result.await();
        }
        return result.getValue();
    }

    private class CompletableAsyncResult<T> implements AsyncResult {

        private int status = START;

        public static final int START = 1;
        public static final int SUCCESS = 2;
        public static final int FAIL = 3;

        private T result;

        private final Object lock; // final 防止引用发生变化，导致锁失败。

        private Exception ex;

        private Optional<AsyncCallback<T>> callback;

        public CompletableAsyncResult(AsyncCallback<T> callback) {
            lock = new Object();
            this.callback = Optional.ofNullable(callback);
        }

        @Override
        public boolean isCompleted() {
            return status != START;
        }

        public void setValue(T val) {
            result = val;
            status = SUCCESS;
            this.callback.ifPresent(ac -> ac.onComplete(result, Optional.<Exception>empty()));
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        public void setException(Exception ex) {
            this.ex = ex;
            status = FAIL;
            this.callback.ifPresent(ac -> ac.onComplete(null, Optional.of(ex)));
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        @Override
        public T getValue() throws ExecutionException {
            switch (status) {
                case SUCCESS: return result;
                case FAIL: throw new ExecutionException(ex);
                default: throw new IllegalStateException("Execution not completed yet");
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                if (!isCompleted()) {
                    lock.wait();
                }
            }
        }

    }

}
