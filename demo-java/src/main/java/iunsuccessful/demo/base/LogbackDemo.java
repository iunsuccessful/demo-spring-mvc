package iunsuccessful.demo.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by LiQZ on 2017/1/11.
 */
public class LogbackDemo {

    public static final Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {
        logger.debug("this is debug.");
        logger.info("this is info.");
        logger.warn("this is warn.");
        logger.error("this is error.");
    }

}
