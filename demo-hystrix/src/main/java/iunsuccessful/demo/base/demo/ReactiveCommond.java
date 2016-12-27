package iunsuccessful.demo.base.demo;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

/**
 * 执行成功后回调
 * Created by LiQZ on 2016/12/27.
 */
public class ReactiveCommond extends HystrixObservableCommand<String> {

    public static final Logger logger = LoggerFactory.getLogger(ReactiveCommond.class);

    public final String name;

    public ReactiveCommond(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.empty();
    }

    @Override
    public Observable<String> observe() {
        logger.debug("observe");
        return Observable.empty();
    }

    public static void main(String[] args) {
        ReactiveCommond commond = new ReactiveCommond("ReactiveCommond");
        String s = commond.observe().toBlocking().single();
        System.out.println(s);
    }
}
