package iunsuccessful.demo.java8.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;

/**
 * http://it.deepinmind.com/java/2015/03/17/20-examples-of-date-and-time-api-from-Java8.html
 * Created by Anonymous on 2016-04-10.
 */
public class Java8DateDemo {

    private static final LocalDate today = LocalDate.now();
    private static final LocalTime now = LocalTime.now();

    public static void main(String[] args) {
        getToday();
        getYearMonthDay();
        getSpecialDate();
        equalsDays();
        birthDay();
        getCurrentTime();
        addHours();
        oneWeekAgo();
        clock();
    }

    /**
     * 示例1 如何 在Java 8中获取当天的日期
     */
    private static void getToday() {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date:" + today);
    }

    /**
     * 示例2 如何在Java 8中获取当前的年月日
     */
    private static void getYearMonthDay() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year: %d Month: %d Day: %d \t \n", year, month, day);
    }

    /**
     * 示例3 在Java 8中如何获取某个特定的日期
     */
    private static void getSpecialDate() {
        LocalDate dateOfBirth = LocalDate.of(1990, 10, 19);
        System.out.println("Your Date of birth is: " + dateOfBirth);
    }

    /**
     * 示例4 在Java 8中如何检查两个日期是否相等
     */
    private static void equalsDays() {
        LocalDate date = LocalDate.of(2016, 4, 10);
        if (date.equals(LocalDate.now())) {
            System.out.printf("Today %s and date %s are same date %n", LocalDate.now(), date);
        }
    }

    /**
     * 示例5 在Java 8中如何检查重复事件，比如说生日
     */
    private static void birthDay() {
        LocalDate dateOfBirth = LocalDate.of(1990, 10, 19);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many happy returns of the day!!");
        } else {
            System.out.println("Sorry, Today is not your birthday!");
        }
    }

    /**
     * 示例6 如何在Java 8中获取当前时间
     */
    private static void getCurrentTime() {
        LocalTime now = LocalTime.now();
        System.out.println("Local time now: " + now);
    }

    /**
     * 示例7 如何增加时间里面的小时数
     */
    private static void addHours() {
        LocalTime now = LocalTime.now();
        LocalTime newTime = now.plusHours(2);
        System.out.println("Time after 2 hours: " + newTime);
    }

    /**
     * 示例8 如何获取1周后的日期
     * 示例9 一年前后的日期
     */
    private static void oneWeekAgo() {
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Date after 1 week: " + nextWeek);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year: " + nextYear);
    }

    /**
     * 示例10 在Java 8中使用时钟
     * <p>用Clock来替代System.currentTimeInMillis()与 TimeZone.getDefault()方法</p>
     */
    private static void clock() {
        Clock clock = Clock.systemUTC();
        System.out.println("Clock: " + clock.millis());
        System.out.println(System.currentTimeMillis());
        Clock.systemDefaultZone();
        System.out.println("Clock: " + clock.getZone());

    }



}
