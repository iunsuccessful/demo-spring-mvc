package iunsuccessful.demo.spring.clients;

import feign.Param;
import feign.RequestLine;
import iunsuccessful.demo.spring.httpclient.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * 依韵 2020/3/27
 */
@FeignClient(name = "testClient", url = "https://api.github.com${spring.profiles.active}")
public interface TestClient {

    @RequestLine("GET {test}")
    Map<String, String> list(@Param("test") String test);

}
