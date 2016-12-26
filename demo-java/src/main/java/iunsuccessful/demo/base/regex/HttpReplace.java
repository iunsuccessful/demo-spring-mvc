package iunsuccessful.demo.base.regex;

/**
 * Created by LiQZ on 2016/11/28.
 */
public class HttpReplace {

    public static void main(String[] args) {
        System.out.println("http://www.baidu.com".replaceAll("http://", "").replaceAll("https://", ""));
        System.out.println("http://www.baidu.com".replaceAll("http(s*)://", ""));
        System.out.println("https://www.baidu.com".replaceAll("http(s*)://", ""));
    }

}
