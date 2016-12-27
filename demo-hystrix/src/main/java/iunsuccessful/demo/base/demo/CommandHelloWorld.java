package iunsuccessful.demo.base.demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Hello world demo
 * Created by LiQZ on 2016/12/27.
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private static final Logger logger = LoggerFactory.getLogger(CommandHelloWorld.class);

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "Hello " + name + "!";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String s = new CommandHelloWorld("Bob").execute();
        logger.debug(s);
        Future<String> fs = new CommandHelloWorld("Bob").queue();
        logger.debug(fs.get());
        Observable<String> os = new CommandHelloWorld("Bob").observe();
        logger.debug(os.toBlocking().single());
    }

}
