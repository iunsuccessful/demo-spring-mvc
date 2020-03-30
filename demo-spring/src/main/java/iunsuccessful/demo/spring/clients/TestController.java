package iunsuccessful.demo.spring.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 依韵 2020/3/27
 */
@RestController
public class TestController {

    @Autowired
    private TestClient testClient;

    @RequestMapping("index")
    public Map<String, String> list() {
        return testClient.list("github");
    }

}
