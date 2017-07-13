package iunsuccessful.demo.base.date;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by LiQZ on 2017/6/5.
 */
public class CalendarDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -8);
        Date begin = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date end = calendar.getTime();
        System.out.println("begin: ");
        System.out.println(DateFormatUtils.format(begin, "yyyy-MM-dd HH:mm:ss"));
        System.out.println("end: ");
        System.out.println(DateFormatUtils.format(end, "yyyy-MM-dd HH:mm:ss"));
    }

}
