package iunsuccessful.demo.spring.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 依韵 2020/3/27
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestClient testClient;

    @Autowired
    private NutsClient nutsClient;

    @RequestMapping("test")
    public Map<String, String> list() {
        return testClient.list("github");
    }

    @RequestMapping("ok")
    public String get() {
        StopWatch stopWatch = new StopWatch("http");
        stopWatch.start();
        nutsClient.list();
        stopWatch.stop();
        nutsClient.list();
        logger.info("prettyPrint {} ", stopWatch.prettyPrint());
        return "OK";
    }

}
