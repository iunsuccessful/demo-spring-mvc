package iunsuccessful.demo.spring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 依韵 2021/12/2
 */
@Configuration
public class FeignConfig {

    /**
     * 指定feign序列化方法
     *
     * @return Feign.Builder
     */
    @Bean
    public Encoder feignEncoder() {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(new ObjectMapper());
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new SpringEncoder(objectFactory);
    }

    /**
     * 防止天猫响应太慢，这里就不设置超时时间了
     */
//    @Bean
//    public Request.Options options() {
//        return new Request.Options(4_000, 4_000);
//    }

    /**
     * 实例化ObjectMapper
     *
     * @return ObjectMapper
     */
    @Bean(name = "objectMapper")
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

//    @Bean(name = "xmlMapper")
//    public XmlMapper getXmlMapper() {
//        XmlMapper xmlMapper = new XmlMapper();
//        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        xmlMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false);
//        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        return xmlMapper;
//    }

    /**
     * feign输出日志
     *
     * @return Logger.Level
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
