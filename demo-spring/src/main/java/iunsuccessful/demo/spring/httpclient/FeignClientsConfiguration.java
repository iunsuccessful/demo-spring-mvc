package iunsuccessful.demo.spring.httpclient;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 这里面配置的是 Spring 的解析方式与 Feign 结合的方式，感觉还停复杂的呢。
 * 依韵 2020/3/27
 */
@Configuration(proxyBeanMethods = false)
public class FeignClientsConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Autowired(required = false)
    private Logger logger;

//    @Bean
//    @ConditionalOnMissingBean
//    public Decoder feignDecoder() {
//        return new OptionalDecoder(new ResponseEntityDecoder(new SpringDecoder(this.messageConverters)));
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public Encoder feignEncoder() {
//        return new SpringEncoder(this.messageConverters);
//    }


    @Bean
    @ConditionalOnMissingBean
    public Retryer feignRetryer() {
        return Retryer.NEVER_RETRY;
    }

    @Bean
    @Scope("prototype")
    @ConditionalOnMissingBean
    public Feign.Builder feignBuilder(Retryer retryer) {
        return Feign.builder().retryer(retryer);
    }

}
