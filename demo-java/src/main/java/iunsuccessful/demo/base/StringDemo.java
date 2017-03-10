package iunsuccessful.demo.base;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Created by LiQZ on 2017/2/24.
 */
public class StringDemo {

    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.println(a);
        System.out.println(a.toString());

        System.out.println(StringUtils.isNotBlank(""));
        System.out.println(!"0".equals("0"));
        System.out.println(StringUtils.isNotBlank(null));
        System.out.println(Objects.equals("0", null));
        System.out.println(Objects.equals("0", "0"));
        System.out.println(Objects.equals("0", ""));
    }

}
