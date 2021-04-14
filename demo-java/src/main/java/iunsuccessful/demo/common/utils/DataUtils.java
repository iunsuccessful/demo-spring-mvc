package iunsuccessful.demo.common.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author LiQZ on 2016/4/11.
 */
public class DataUtils {

    class RandomStringSupplier implements Supplier<String> {
        @Override
        public String get() {

            return null;
        }
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static List<String> getRandomList(int length) {
        Random random = new Random();
        List<String> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++ ) {
            int number = random.nextInt(10) + 1;
            list.add(getRandomString(number));
        }
        return list;
    }

    public static List<Integer> getRandomIntegerList(int length) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++ ) {
            int number = random.nextInt(10000) + 1;
            list.add(number);
        }
        return list;
    }

    public static void main(String[] args) {
        Date date = new Date(1460345907000L);
//        Instant.now(Clock.)
//        System.out.println(DateFormat.);
    }

}
