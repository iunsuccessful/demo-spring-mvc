package iunsuccessful.demo.http;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 依韵 2020/4/1
 */
public class OKHttpClientDemo {

    private static final Logger logger = LoggerFactory.getLogger(OKHttpClientDemo.class);

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);

//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                logger.info("exception ", e);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                logger.info("body {}", response.body().string());
//            }
//        });

        Response response = call.execute();
        System.out.println(response.body().string());

    }

}
