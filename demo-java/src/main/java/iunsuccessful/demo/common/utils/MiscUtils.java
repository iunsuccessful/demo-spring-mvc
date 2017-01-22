package iunsuccessful.demo.common.utils;

/**
 * Created by LiQZ on 2017/1/22.
 */
public class MiscUtils {

    public static void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
