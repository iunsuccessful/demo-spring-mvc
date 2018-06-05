package iunsuccessful.demo.base.string;

import java.text.MessageFormat;

/**
 * Create By LiQZ 2018/5/17
 */
public class MessageFormartDemo {

    public static void main(String[] args) {
        String demo = MessageFormat.format("{0} {1} {0}", "测试", "测试2");
        System.out.println(demo);
    }

}
