package iunsuccessful.demo.json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Fastjson  有个坑，1.1 以下版本，转换成 json 时，会帮你自动按字母排序。在 签名 时，因为 spring mvc
 * 用的 jackson, 会造成签名数据，跟发送数据签名不一致，导致签名错误。
 * <p/>
 *
 * @author Created by 依韵 on 2019/2/26 .
 */
public class FastjsonDemo {

    public static void main(String[] args) {
        Map orderQueryParam = new HashMap();
        orderQueryParam.put("startTime", "2019-02-25 00:07:00");
        orderQueryParam.put("endTime", "2019-02-25 12:00:01");
        orderQueryParam.put("pageNo", "1");
        orderQueryParam.put("pageSize", "10");
        orderQueryParam.put("orderStatus", "10");

        Map body = new HashMap();
        body.put("orderQuery", orderQueryParam);

        String jsonString = JSON.toJSONString(body);
        System.out.println(jsonString);
    }

}
