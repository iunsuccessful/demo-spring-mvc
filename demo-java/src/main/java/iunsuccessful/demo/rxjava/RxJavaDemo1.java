package iunsuccessful.demo.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 依韵 2022/4/9
 */
public class RxJavaDemo1 {

    private static final Logger logger = LoggerFactory.getLogger(RxJavaDemo1.class);

    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                int i = 0;

                while (true) {
                    // Thread.sleep(10);
                    i++;
                    emitter.onNext(i);
                    logger.info("每 500ms 发送一次数据：{}",  i);
                }

            }

        })
                // .subscribeOn(Schedulers.newThread()) //使被观察者存在独立的线程执行
                 .observeOn(Schedulers.newThread()) //使观察者存在独立的线程执行
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Throwable {
                        Thread.sleep(5000);
                        logger.info("每 5000ms 接收一次数据 {}", integer);
                    }
                });

    }

}
