package iunsuccessful.demo.spring;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.slf4j.LoggerFactory;

/**
 * 依韵 2020/3/27
 */
public class NormalFeignClient {


    public static void main(String[] args) {

        // 方法一，直接创建

        Object github = Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
//                .errorDecoder(new SOAPErrorDecoder())
                // 可能是换成 Spring 的 @RequestMapper 之类用的
//                .contract(new JAXRSContract())
                .decode404()
                // 加一些通用参数，如用户登录信息等。
//                .requestInterceptor()
//                .requestInterceptors()
                // 不是 2XX 的响应处理
//                .errorDecoder(new MyErrorDecoder())
                // 重试也没用后的处理策略
//                .exceptionPropagationPolicy(config.getExceptionPropagationPolicy());
                .target(Object.class, "https://api.github.com");

        // 方法二，使用 Feign builder 创建

        Feign.Builder builder = Feign.builder()
                .retryer(Retryer.NEVER_RETRY)
                // .XXX
                .decode404();

        Object github2 = builder.target(Object.class, "https://api.github.com");

    }

}
