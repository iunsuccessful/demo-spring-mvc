package iunsuccessful.demo.guava.strdemo;

import com.google.common.base.CaseFormat;

/**
 * 依韵 2022/3/19
 */
public class CaseDemo {

    public static void main(String[] args) {
        String result = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL).convert("testCamel");
        System.out.println(result);
    }

}
