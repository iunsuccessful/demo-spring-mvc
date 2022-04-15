package iunsuccessful.demo.spring.service;

import iunsuccessful.demo.spring.controller.MyRateLimiter;
import org.springframework.stereotype.Service;

/**
 * 依韵 2022/4/14
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    @MyRateLimiter(name = "test2", limit = 1)
    public String test() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (true) {
            throw new RuntimeException("test");
        }
        return "test";
    }

}
