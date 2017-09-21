package iunsuccessful.demo.java8.time;

/**
 * System.currentTimeMillis() -> 单位是：毫秒
 * Created by LiQZ on 2017/8/17.
 */
public class SystemCurrDemo {

    public static void main(String[] args) {
        // 1502934861140 -> 2017年8月17日 9:54:35
        // 1502935056750 -> 2017年8月17日9:57:49
        Long beginTime = System.currentTimeMillis();
        System.out.println(beginTime);
        System.out.println(1502935056750l - 1502934861140l);
        System.out.println(5 * 60 * 1000);
    }


}
