package iunsuccessful.demo.apache.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class Log4jDemo {

    private static final Logger logger = LoggerFactory.getLogger(Log4jDemo.class);

    public static void main(String[] args) {
        try {
            new Log4jDemo().throwException();
        } catch (Exception e) {
            logger.error("excetpion order {}", "20190529160538", e);
        }
    }

    private void throwException() {
        if (true) {
            throw new RuntimeException("I am exception.");
        }
    }

}
