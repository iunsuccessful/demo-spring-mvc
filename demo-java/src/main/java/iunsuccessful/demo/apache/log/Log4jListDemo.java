package iunsuccessful.demo.apache.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 依韵 2019-08-01
 */
public class Log4jListDemo {

    private static final Logger logger = LoggerFactory.getLogger(Log4jListDemo.class);

    public static void main(String[] args) {
        List<Log4jBean> list = new ArrayList<>();
        list.add(new Log4jBean("test2", "type2"));
        list.add(new Log4jBean("test3", "type3"));
        logger.info("list data {}", list);
    }

}
