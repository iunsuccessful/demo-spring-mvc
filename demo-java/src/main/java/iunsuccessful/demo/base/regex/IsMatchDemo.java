package iunsuccessful.demo.base.regex;

import java.util.regex.Pattern;

/**
 * 依韵 2021/3/18
 */
public class IsMatchDemo {

    public static void main(String[] args) {
//        System.out.println(Pattern.matches("\\\\[\\d+\\\\]", "[7029]"));
//        System.out.println(Pattern.matches("[\\d+]", "[7029]"));
//        System.out.println(Pattern.matches("\\\\[\\d+]", "[7029]"));
//        System.out.println(Pattern.matches("\\[\\d+]", "[7029]"));
//        System.out.println(Pattern.matches("\\[\\d+]$", "[7029]"));
//        System.out.println(Pattern.matches(".*\\[\\d+]$", "aaa[7029]"));
//        System.out.println(Pattern.matches("\\[\\d+]$", "[7029]aaa"));
//        System.out.println(Pattern.matches("\\[7029]", "[7029]"));

        System.out.println(Pattern.matches("^(10|11|12|13|14|15|16|17|19|18|50|55|58|80|88|66|31|77|39)[0-9]{11}$|^[0-9]{13}$", "4316791434176"));
    }

}
