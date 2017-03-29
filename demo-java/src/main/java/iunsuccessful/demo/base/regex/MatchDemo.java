package iunsuccessful.demo.base.regex;

import java.util.regex.Pattern;

/**
 * Created by LiQZ on 2016/12/15.
 */
public class MatchDemo {

    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("\\d");
//        System.out.println(pattern.matcher("2.5").matches());

//        1|0\.[0-9]{0,2}
//        Pattern twoFloatNumber = Pattern.compile("1|1.0|1.00|0\\.[1-9][0-9]{0,1}");
//        System.out.println(twoFloatNumber.matcher("0.11").matches());

//        String reg = "\\d{6,10}";
//        Pattern pattern = Pattern.compile(reg);
//        System.out.println(pattern.matcher("50000056").matches());

//        String reg = "[0-9]*\\.?[0-9]+";
//        Pattern pattern = Pattern.compile(reg);
//        System.out.println(pattern.matcher("111.111111").matches());

//        (\s)|([0-9]*\.?[0-9]+)
        String reg = "(\\s*)|([0-9]*\\.?[0-9]+)";
        Pattern pattern = Pattern.compile(reg);
        System.out.println(pattern.matcher("").matches());

    }

}
