package iunsuccessful.demo.spring;

import iunsuccessful.demo.spring.httpclient.FeignClientsRegister;
import iunsuccessful.demo.spring.httpclient.FeignHttpClientProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 依韵 2020/3/24
 */
@EnableConfigurationProperties({FeignHttpClientProperties.class})
@Import(FeignClientsRegister.class)
@EnableAspectJAutoProxy
@SpringBootApplication
public class WebConfig {

    public static void main(String[] args) {
        SpringApplication.run(WebConfig.class, args);
    }



}
