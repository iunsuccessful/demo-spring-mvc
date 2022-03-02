package iunsuccessful.demo.guava.strdemo;

import com.google.common.base.Splitter;

/**
 * Created by LiQZ on 2018/1/25.
 */
public class Spliter {

    public static void main(String[] args) {
        String str = "aaa;;aaa;a;a";
        System.out.println(Splitter.on(';').trimResults().omitEmptyStrings().split(str));
    }

}
