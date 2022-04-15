package iunsuccessful.demo.guava.basedemo;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * 依韵 2022/3/19
 */
public class StopwatchDemo {

    private static final Logger logger = LoggerFactory.getLogger(StopwatchDemo.class);

    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(100L);
        stopwatch.stop(); // optional

        Duration duration = stopwatch.elapsed();

        logger.info("time: " + stopwatch); // formatted string like "12.3 ms"
        logger.info("time: " + duration.toNanos());
    }

}
