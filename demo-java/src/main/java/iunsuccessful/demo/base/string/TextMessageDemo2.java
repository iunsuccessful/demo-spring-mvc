package iunsuccessful.demo.base.string;

import java.text.MessageFormat;
import java.text.ParsePosition;

/**
 * 依韵 2021/3/17
 */
public class TextMessageDemo2 {

    public static void main(String[] args) {
        String message = "预售a天发货（2021-03-17号）";

        MessageFormat mf = new MessageFormat("预售{0, number}天发货");
        ParsePosition pp = null;
        try {
            pp = new ParsePosition(0);
            Object[] objs = mf.parse(message, pp);
            for (Object o: objs) {
                System.out.println(o);
            }
        } catch (Exception e) {
            System.out.println(pp.getErrorIndex());
            e.printStackTrace();
        }


    }

}
