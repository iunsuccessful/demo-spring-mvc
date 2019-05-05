package iunsuccessful.demo.apache.lang3;

import org.apache.commons.lang3.StringUtils;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/5/5 .
 */
public class StringUtilsDemo {

    public static void main(String[] args) {
        boolean result = StringUtils.isAllBlank("", null, "a");
        System.out.println(result);
        result = StringUtils.isAnyBlank("", null, "a");
        System.out.println(result);
    }

}
