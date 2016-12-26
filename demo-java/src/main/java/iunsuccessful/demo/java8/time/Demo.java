package iunsuccessful.demo.java8.time;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.time.*;

/**
 * @author LiQZ on 2016/10/17.
 */
public class Demo {

    /**
     * 数据库时间保存为秒
     * 原因：不用再去管 Linux, MySQL 等的时区问题了。
     */
    public static void main(String[] args) {
        // 现在时间
        LocalDateTime now = LocalDateTime.now();
        PrintUtils.print(now, "YYYY-MM-dd HH:mm:ss");

        // 秒转换为 LocalDateTime
        int seconds = (int) (System.currentTimeMillis() / 1000);
        System.out.println(seconds);

        LocalDateTime secondsTime = LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.ofHours(+8));
        PrintUtils.print(secondsTime, "YYYY-MM-dd HH:mm:ss");

        // 现在时间转换成秒
        long secondLong = secondsTime.toEpochSecond(ZoneOffset.ofHours(8));
        System.out.println(secondLong);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());
        PrintUtils.print(zonedDateTime, "YYYY-MM-dd HH:mm:ss");
        System.out.println(zonedDateTime.toEpochSecond());

        // Zone of 的使用
        ZonedDateTime zonedDateTimeCTT = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        PrintUtils.print(zonedDateTimeCTT, "YYYY-MM-dd HH:mm:ss");
        System.out.println(zonedDateTimeCTT.toEpochSecond());

        // 判断会员生日 10-19
        MonthDay birthday = MonthDay.of(10, 19);
        System.out.println(MonthDay.from(LocalDate.now()).equals(birthday));


    }


}
