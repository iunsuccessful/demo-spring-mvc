package iunsuccessful.demo.base.string;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ascii 160 问题处理
 * 问题描述：
 *  在使用 StringUtils.trim("   河北省廊坊市   ") 时发现后面的空格居然去不掉，发现这句话的最后一个空格是
 *  &nbsp; 160 位的空格
 *  网络上常见的解决方法：String.replaceAll("\\u00A0","")
 * Created by LiQZ on 2018/1/3.
 */
public class StringUtilsDemo {


    public static void main(String[] args) {
//        String name = StringUtils.trim("   河北省廊坊市   ");
//        System.out.println(name.indexOf(" ")); // 中文空格
//        System.out.println(name);
        System.out.println((int)' ');
        System.out.println((int)' ');
        System.out.println((char) 65);
        System.out.println((char) 97);
        System.out.println((int)' ');
        System.out.println((int)' ');

    }

    /**
     * 空格没去掉, 用这个过滤出中文
     */
    public static String getContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return m.group(0);
        }
        return null;
    }


}
