package iunsuccessful.demo.base.string;

import java.text.MessageFormat;
import java.text.ParsePosition;

/**
 * Create By LiQZ 2018/12/28
 */
public class TextMessageDemo {

    public static void main(String[] args) {
//        String text = "<button class=\"btn btn-warning btn-xs col-lg-offset-1 col-md-offset-1\" type=\"button\" style=\"margin-left:3%;\" onclick=\"ShowDetailInfo('112847651|112823305|10元天翼代金券（江苏通信置业苏信南湖店）');\">查看</button><button class=\"btn btn-warning btn-xs col-lg-offset-1 col-md-offset-1\" type=\"button\" style=\"margin-left:3%;\" onclick=\"ShowBackModal('112847651|112823305|10元天翼代金券（江苏通信置业苏信南湖店）');\">返销</button>";
        String text = "ShowDetailInfo('112847651|112823305|10元天翼代金券（江苏通信置业苏信南湖店）');";

        MessageFormat mf = new MessageFormat("ShowDetailInfo(''{0}'')");
        ParsePosition pp = null;
        try {
             pp = new ParsePosition(0);
            Object[] objs = mf.parse(text, pp);
            for (Object o: objs) {
                System.out.println(o);
            }
        } catch (Exception e) {
            System.out.println(pp.getErrorIndex());
            e.printStackTrace();
        }
    }

}
