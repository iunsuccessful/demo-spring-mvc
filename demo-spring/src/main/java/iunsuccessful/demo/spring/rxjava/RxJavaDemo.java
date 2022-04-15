package iunsuccessful.demo.spring.rxjava;

import io.reactivex.rxjava3.core.Flowable;

/**
 * 依韵 2022/4/8
 */
public class RxJavaDemo {

    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);



    }

}
