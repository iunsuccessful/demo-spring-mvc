package iunsuccessful.demo.http;

import cn.hutool.http.HttpUtil;

/**
 * 简单粗暴，底层用的 HttpConnection
 *
 * 依韵 2020/4/1
 */
public class HutoolHttpClientDemo {

    public static void main(String[] args) {
        String result1= HttpUtil.get("https://www.baidu.com");

        System.out.println(result1);

    }

}
