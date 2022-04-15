package iunsuccessful.demo.spring.controller;

import io.github.resilience4j.core.EventConsumer;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.event.RateLimiterOnFailureEvent;
import iunsuccessful.demo.spring.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * 依韵 2022/3/2
 */
@RestController
public class RateLimiterController {

    private static final Logger logger = LoggerFactory.getLogger(RateLimiterController.class);

    @Autowired
    private TestService testService;

    // 某个方法的调用率限制为每秒不超过10个请求。
    RateLimiterConfig config = RateLimiterConfig.custom()
            // 在一次刷新周期内，允许执行的最大请求数
            .limitForPeriod(10)
            // 限流器每隔limitRefreshPeriod刷新一次，将允许处理的最大请求数量重置为limitForPeriod。
            .limitRefreshPeriod(Duration.ofSeconds(1))
            // 线程等待权限的默认等待时间
            .timeoutDuration(Duration.ofMillis(25))
            .build();

    RateLimiterRegistry registry = RateLimiterRegistry.of(config);

    RateLimiter limiter = registry.rateLimiter("flightSearchService");
    // FlightSearchService and SearchRequest creation omitted


    public RateLimiterController() {

        limiter.getEventPublisher().onFailure(new EventConsumer<RateLimiterOnFailureEvent>() {
            @Override
            public void consumeEvent(RateLimiterOnFailureEvent event) {
                logger.warn("{} 限流了~", event.getRateLimiterName());
            }
        });

    }

    @RequestMapping("rate-limiter")
    public String test() {

        Supplier<String> flightsSupplier =
                RateLimiter.decorateSupplier(limiter, () -> {
                    return test2();
                });

        return flightsSupplier.get();

    }

    private String test2() {
        return "test";
    }

    @RequestMapping("rate-limiter2")
    public String test3() {
        return testService.test();
    }


}
