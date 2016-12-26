package iunsuccessful.demo.patterns.async_method_invocation;

import iunsuccessful.demo.patterns.common.DataUtils;

import java.util.concurrent.ExecutionException;

/**
 * @author LiQZ on 2016/10/8.
 */
public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadAsyncExecutor executor = new ThreadAsyncExecutor();
        AsyncResult<Integer> result1 = executor.start(DataUtils.lazyval(1000, 1000));
        AsyncResult<Integer> result2 = executor.start(DataUtils.lazyval(500, 500));
        AsyncResult<Integer> result3 = executor.start(DataUtils.lazyval(20, 20));


        // like netty channel.xx().sync();
        // 阻塞在这里，等待这个 lazyVal 完成。
        executor.start(DataUtils.lazyval(1200, 1200), callback("result 4 callback")).await();
        DataUtils.log("Prepare Completed.");

        Integer re1 = executor.get(result1);
        DataUtils.log("re1 eq " + re1);
        executor.get(result2);
        executor.get(result3);
    }

    private static <T> AsyncCallback<T> callback(String name) {
        return (value, ex) -> {
            if (ex.isPresent()) {
                DataUtils.log(name + " failed: " + ex.map(Exception::getMessage).orElse(""));
            } else {
                DataUtils.log(name + ": " + value);
            }
        };
    }

}
