package iunsuccessful.demo.spring.httpclient;

import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 依韵 2020/3/27
 */
public class FeignClientFactoryBean implements FactoryBean<Object>, ApplicationContextAware {

    private Class<?> type;

    private String name;

    private String url;

    private ApplicationContext applicationContext;

    @Override
    public Object getObject() throws Exception {

        Decoder decoder = applicationContext.getBean(Decoder.class);
        Encoder encoder = applicationContext.getBean(Encoder.class);

        Feign.Builder builder = Feign.builder()
            .retryer(Retryer.NEVER_RETRY)
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .encoder(encoder)
            .decoder(decoder);

        Client client = applicationContext.getBean(Client.class);
        builder.client(client);
        // 这里还有 balance 的处理
        return builder.target(new Target.HardCodedTarget<>(this.type, this.name, this.url));
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
