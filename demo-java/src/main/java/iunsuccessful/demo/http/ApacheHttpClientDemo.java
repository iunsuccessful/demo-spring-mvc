package iunsuccessful.demo.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * 依韵 2020/4/1
 */
public class ApacheHttpClientDemo {

    public static void main(String[] args) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpUriRequest request = new HttpGet("http://www.baidu.com");
        HttpResponse response = client.execute(request);
        System.out.println(request);
    }

}
