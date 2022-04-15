package iunsuccessful.demo.spring.controller;

import java.lang.annotation.*;

/**
 * 依韵 2022/4/14
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRateLimiter {

     String name() default "";

     int limit() default 20;

}
