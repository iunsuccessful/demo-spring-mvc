package iunsuccessful.demo.apache.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 依韵 2019-08-01
 */
public class MapDemo {

    private static final Logger logger = LoggerFactory.getLogger(MapDemo.class);

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "123");

        logger.info(" {} ", map);
    }

}
