package iunsuccessful.demo.base.regex;

import java.util.regex.Pattern;

/**
 * 依韵 2021/3/18
 */
public class IsMatchDemo {

    public static void main(String[] args) {
        System.out.println(Pattern.matches("\\\\[\\d+\\\\]", "[7029]"));
        System.out.println(Pattern.matches("[\\d+]", "[7029]"));
        System.out.println(Pattern.matches("\\\\[\\d+]", "[7029]"));
        System.out.println(Pattern.matches("\\[\\d+]", "[7029]"));
        System.out.println(Pattern.matches("\\[\\d+]", "[7029]"));
        System.out.println(Pattern.matches("\\[7029]", "[7029]"));
    }

}
