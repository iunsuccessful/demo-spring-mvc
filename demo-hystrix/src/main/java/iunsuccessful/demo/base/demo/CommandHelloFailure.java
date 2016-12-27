package iunsuccessful.demo.base.demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 降级
 * Created by iunsuccessful on 2016/12/27.
 */
public class CommandHelloFailure extends HystrixCommand<String> {

    public static final Logger logger = LoggerFactory.getLogger(CommandHelloFailure.class);

    public final String name;

    public CommandHelloFailure(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        throw new RuntimeException("this command always fails");
    }

    @Override
    protected String getFallback() {
        return "Hello Failure " + name + "!";
    }

    public static void main(String[] args) {
        String s = new CommandHelloFailure("Bob").execute();
        logger.debug(s);
    }



}
