package iunsuccessful.demo.spring.controller;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

/**
 * 依韵 2022/3/2
 */
@RestController
public class IndexController {

    // 自定义断路器配置
    CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
            .failureRateThreshold(2)
            // 以百分比的方式配置，断路器把调用时间大于slowCallDurationThreshold的调用视为满调用，当慢调用比例大于等于阈值时，断路器开启，并进行服务降级。
            .slowCallRateThreshold(1)
            // 断路器从开启过渡到半开应等待的时间。
            // .waitDurationInOpenState(Duration.ofMillis(1000))
            // 配置调用时间的阈值，高于该阈值的呼叫视为慢调用，并增加慢调用比例。
            .slowCallDurationThreshold(Duration.ofMillis(200))
            // 断路器在半开状态下允许通过的调用次数。
            // .permittedNumberOfCallsInHalfOpenState(3)
            // 断路器计算失败率或慢调用率之前所需的最小调用数（每个滑动窗口周期）。例如，
            // 如果minimumNumberOfCalls为10，则必须至少记录10个调用，然后才能计算失败率。如果只记录了9次调用，即使所有9次调用都失败，断路器也不会开启。
            .minimumNumberOfCalls(10)
            // 配置滑动窗口的类型，当断路器关闭时，将调用的结果记录在滑动窗口中。滑动窗口的类型可以是count-based或time-based。
            // 如果滑动窗口类型是COUNT_BASED，将会统计记录最近slidingWindowSize次调用的结果。如果是TIME_BASED，将会统计记录最近slidingWindowSize秒的调用结果。
            .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
            // 配置滑动窗口的大小。
            .slidingWindowSize(5)
            // .recordException(e -> INTERNAL_SERVER_ERROR.equals(INTERNAL_SERVER_ERROR))
            .recordExceptions(IOException.class, TimeoutException.class)
            // .ignoreExceptions(LowResourceException.class, RetryTestException.class)
            .build();

    // 使用默认配置创建circuitBreakerRegistry
    CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.ofDefaults();

    // 使用circuitBreakerRegistry创建断路器，配置是默认配置
    CircuitBreaker circuitBreakerWithDefaultConfig = circuitBreakerRegistry.circuitBreaker("name1");

    // 使用circuitBreakerConfig创建注册器，进而创建断路器，配置是自定义配置
    CircuitBreaker circuitBreakerWithCustomConfig = CircuitBreakerRegistry.of(circuitBreakerConfig).circuitBreaker("diy");

    @RequestMapping("index")
    public String index() {

//        circuitBreakerWithCustomConfig.decorateCallable(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return test2("index");
//            }
//        }).call();

        return circuitBreakerWithCustomConfig.executeTrySupplier(new Supplier<Try<String>>() {
            @Override
            public Try<String> get() {
                return Try.of(() -> test2("index"));
            }
        }).getOrElse("fail");

    }



    private String test2(String s) {
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }

}
