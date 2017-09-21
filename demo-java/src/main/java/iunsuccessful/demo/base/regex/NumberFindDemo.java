package iunsuccessful.demo.base.regex;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LiQZ on 2017/8/17.
 */
public class NumberFindDemo {

    public static void main(String[] args) throws ParseException {
        Pattern pattern = Pattern.compile("([0-9-]*)至([0-9-]*),共创建评论数(\\d*)条,差评数\\(一星和二星的评论\\)有(\\d*)条");
        String text = "2017-08-07至2017-08-13,共创建评论数8条,差评数(一星和二星的评论)有7条";
        Matcher m = pattern.matcher(text);
        while (m.find()) {
            System.out.println(m.group(1)); // like: $1
            System.out.println(m.group(2)); // like: $2
            System.out.println(m.group(3));
            System.out.println(m.group(4));
        }

        MessageFormat mf = new MessageFormat("{0}至{1},共创建评论数{2}条,差评数(一星和二星的评论)有{3}条");
        Object[] objs = mf.parse(text);
        for (Object o: objs) {
            System.out.println(o);
        }


    }

}
