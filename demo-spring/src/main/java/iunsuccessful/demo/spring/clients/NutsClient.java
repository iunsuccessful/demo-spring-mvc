package iunsuccessful.demo.spring.clients;

import feign.RequestLine;
import iunsuccessful.demo.spring.httpclient.FeignClient;

/**
 * 依韵 2020/3/27
 */
@FeignClient(name = "nutsClient", url = "https://nuts.3songshu.com")
public interface NutsClient {

    @RequestLine("GET ok")
    String list();

}
