package iunsuccessful.demo.spring.controller;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * 依韵 2022/4/14
 */
@Aspect
@Component
public class RateLimiterAspect {

     RateLimiterRegistry registry = RateLimiterRegistry.ofDefaults();

     @Pointcut("@annotation(iunsuccessful.demo.spring.controller.MyRateLimiter)")
     public void rateLimiter() {

     }
     @Around("rateLimiter()")
     public Object before(ProceedingJoinPoint joinPoint) throws Throwable {

         MethodSignature signature = (MethodSignature) joinPoint.getSignature();
         Method method = signature.getMethod();
         MyRateLimiter rateLimiter = method.getAnnotation(MyRateLimiter.class);
         if (rateLimiter.limit() < 0) {
             return joinPoint.proceed();
         }

         RateLimiter limiter = registry.rateLimiter(rateLimiter.name(), () -> {
             // 某个方法的调用率限制为每秒不超过10个请求。
         return RateLimiterConfig.custom()
                 // 在一次刷新周期内，允许执行的最大请求数
                 .limitForPeriod(rateLimiter.limit())
                 // 限流器每隔 limitRefreshPeriod 刷新一次，将允许处理的最大请求数量重置为 limitForPeriod。
                 .limitRefreshPeriod(Duration.ofSeconds(30))
                 // 线程等待权限的默认等待时间
                 .timeoutDuration(Duration.ofMillis(200))
                 .build();

         });

         return RateLimiter.decorateCheckedSupplier(limiter, joinPoint::proceed).apply();

     }




}
