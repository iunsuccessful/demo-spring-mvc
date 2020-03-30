package iunsuccessful.demo.spring.httpclient;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import iunsuccessful.demo.spring.httpclient.support.ApacheHttpClientConnectionManagerFactory;
import iunsuccessful.demo.spring.httpclient.support.ApacheHttpClientFactory;
import iunsuccessful.demo.spring.httpclient.support.DefaultApacheHttpClientConnectionManagerFactory;
import iunsuccessful.demo.spring.httpclient.support.DefaultApacheHttpClientFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * builder -> client factory -> connections factory;
 *
 * in the auto configuration:
 *
 *      connections factory  + properties -> connection manager
 *      connection manager -> http client
 *
 * 依韵 2020/3/24
 */
@Configuration
public class HttpClientConfiguration {

    @Autowired(required = false)
    private RegistryBuilder registryBuilder;

    private final Timer connectionManagerTimer = new Timer(
            "FeignApacheHttpClientConfiguration.connectionManagerTimer", true);

    private CloseableHttpClient httpClient;

    @Bean
    @ConditionalOnMissingBean
    public HttpClientBuilder apacheHttpClientBuilder() {
        return HttpClientBuilder.create();
    }


    @Bean
    @ConditionalOnMissingBean
    public ApacheHttpClientFactory apacheHttpClientFactory(HttpClientBuilder builder) {
        return new DefaultApacheHttpClientFactory(builder);
    }

    @Bean
    @ConditionalOnMissingBean
    public ApacheHttpClientConnectionManagerFactory connManFactory() {
        return new DefaultApacheHttpClientConnectionManagerFactory();
    }

    @Bean
    @ConditionalOnMissingBean(HttpClientConnectionManager.class)
    public HttpClientConnectionManager connectionManager(
            ApacheHttpClientConnectionManagerFactory connectionManagerFactory,
            FeignHttpClientProperties httpClientProperties) {
        final HttpClientConnectionManager connectionManager = connectionManagerFactory
                .newConnectionManager(httpClientProperties.isDisableSslValidation(),
                        httpClientProperties.getMaxConnections(),
                        httpClientProperties.getMaxConnectionsPerRoute(),
                        httpClientProperties.getTimeToLive(),
                        httpClientProperties.getTimeToLiveUnit(),
                        this.registryBuilder);
        this.connectionManagerTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                connectionManager.closeExpiredConnections();
            }
        }, 30000, httpClientProperties.getConnectionTimerRepeat());
        return connectionManager;
    }

    @Bean
    public CloseableHttpClient httpClient(ApacheHttpClientFactory httpClientFactory,
                                          HttpClientConnectionManager httpClientConnectionManager,
                                          FeignHttpClientProperties httpClientProperties) {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setConnectTimeout(httpClientProperties.getConnectionTimeout())
                .setRedirectsEnabled(httpClientProperties.isFollowRedirects())
                .build();
        this.httpClient = httpClientFactory.createBuilder()
                .setConnectionManager(httpClientConnectionManager)
                .setDefaultRequestConfig(defaultRequestConfig).build();
        return this.httpClient;
    }

    @Bean
    @ConditionalOnMissingBean(Client.class)
    public Client feignClient(HttpClient httpClient) {
        return new ApacheHttpClient(httpClient);
    }

    @PreDestroy
    public void destroy() throws Exception {
        this.connectionManagerTimer.cancel();
        if (this.httpClient != null) {
            this.httpClient.close();
        }
    }





}
