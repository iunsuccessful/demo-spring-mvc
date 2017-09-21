package iunsuccessful.demo.common.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by LiQZ on 2017/8/24.
 */
public class RandomString {

    public static void main(String[] args) {
        System.out.println(RandomStringUtils.random(10));
        System.out.println(RandomStringUtils.randomAscii(10));
        System.out.println(RandomStringUtils.randomAlphabetic(10));
        System.out.println(RandomStringUtils.randomAlphanumeric(10));
        System.out.println(RandomStringUtils.randomNumeric(10));
    }

}
