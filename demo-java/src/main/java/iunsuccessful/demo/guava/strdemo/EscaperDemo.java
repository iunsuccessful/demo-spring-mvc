package iunsuccessful.demo.guava.strdemo;

import com.google.common.escape.CharEscaperBuilder;

/**
 * 依韵 2022/3/19
 */
public class EscaperDemo {

    public static void main(String[] args) {
        CharEscaperBuilder builder = new CharEscaperBuilder();
        builder.addEscape('a', "abc");
        String result = builder.toEscaper().escape("abc");
        System.out.println(result);
    }

}
