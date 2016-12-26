package iunsuccessful.demo.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author LiQZ on 2016/5/24.
 */
public class Java8DateDemo2 {

    public static void main(String[] args) {
//        secondToTime();
//        formatTime();
//        dayOfMonth();
        localTimeDemo();
    }

    private static void secondToTime() {
        Instant instant = Instant.ofEpochSecond(1464019200l);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.ofEpochSecond(1464019200l, 0, ZoneOffset.ofHours(8));
        System.out.println(ldt2);

        LocalDateTime ldt3 = LocalDateTime.of(2016, 5, 24, 0, 0, 0);
        System.out.println(ldt3.toEpochSecond(ZoneOffset.ofHours(8)));

    }

    private static void formatTime() {
        LocalDateTime ldt = LocalDateTime.of(2016, 5, 24, 0, 0, 0);
        System.out.println(ldt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }

    /** LocalDate Demo */
    private static void dayOfMonth() {
        LocalDate today = LocalDate.now();
        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfThisMonth);
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        System.out.println(secondDayOfThisMonth);
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfThisMonth);
        // 取下一天：
        LocalDate nextDay = today.plusDays(1);
        System.out.println(nextDay);
        // 取本月的第一周，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMonday = LocalDate.parse("2016-05-25").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstMonday);
        // 取下个周一
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextMonday);

    }

    /** LocalTime Demo */
    private static void localTimeDemo() {
        // Get now ignore nano of seconds.
        LocalTime now = LocalTime.now().withNano(0);
        LocalTime zero = LocalTime.of(0, 0, 0, 0); // 00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00
        System.out.println(mid);
    }

}
