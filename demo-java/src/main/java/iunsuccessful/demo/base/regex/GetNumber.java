package iunsuccessful.demo.base.regex;

import org.apache.commons.lang3.ArrayUtils;

import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从 一段 URL 中，取出数字
 * @author LiQZ on 2016/11/4.
 */
public class GetNumber {

    /**
     * 下列 URL 中，提取 ID.
     * http://www.yohobuy.com/product/sale/discount/detail?id=200
     * http://m.yohobuy.com/product/sale/discount/detail?id=200
     * http://m.yohobuy.com/product/sale/discount/detail?id=200&cover_url=http://img12.static.yhbimg.com/activity/2016/06/23/18/02b473d70d7bf5875b391284cb0e3c3b05.png&title=测试-james的活动专区&start_date=2016-06-22 00:00:00&product_pool=50
     */
//    public static void main(String[] args) {
//
//        Pattern pattern = Pattern.compile("sale/discount/detail\\?id=(\\d+)");
////        Matcher m = pattern.matcher("http://www.yohobuy.com/product/sale/discount/detail?id=200");
////        Matcher m = pattern.matcher("http://m.yohobuy.com/product/sale/discount/detail?id=200&cover_url=http://img12.static.yhbimg.com/activity/2016/06/23/18/02b473d70d7bf5875b391284cb0e3c3b05.png&title=测试-james的活动专区&start_date=2016-06-22 00:00:00&product_pool=50");
//        Matcher m = pattern.matcher("http://m.yohobuy.com/product/sale/discount/detail?id=200");
//        while (m.find()) {
//            System.out.println(m.group(1)); // like: $1
//        }
//
//    }

    private static Integer preSaleFormat(String text) {

        Integer index = text.indexOf("预售");

        if (index < 0) {
            return null;
        }

        MessageFormat mf = new MessageFormat("预售{0, number}天发货");
        ParsePosition pp = null;
        try {
            pp = new ParsePosition(index);
            Object[] objs = mf.parse(text, pp);
            if (ArrayUtils.isEmpty(objs)) {
                return null;
            }
            return Integer.valueOf(String.valueOf(objs[0]));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(preSaleFormat("口味:预售7天发货_【经典鸡爪味道】泡椒味110gx3袋"));
    }

}
