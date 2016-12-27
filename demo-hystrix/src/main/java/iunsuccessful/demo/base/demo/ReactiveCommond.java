package iunsuccessful.demo.base.demo;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

/**
 * Created by LiQZ on 2016/12/27.
 */
public class ReactiveCommond extends HystrixObservableCommand<String> {

    public final String name;

    public ReactiveCommond(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        return null;
    }
}
