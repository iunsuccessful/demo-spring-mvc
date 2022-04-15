package iunsuccessful.demo;

import com.kuaishou.merchant.open.api.KsMerchantResponse;
import com.kuaishou.merchant.open.api.client.AccessTokenKsMerchantClient;
import com.kuaishou.merchant.open.api.request.KsMerchantOrderDeliverRequest;

/**
 * 依韵 2021/4/17
 */
public class KuaiShouDemo {

    public static void main(String[] args) throws Exception {

        AccessTokenKsMerchantClient tokenKsMerchantClient
                = new AccessTokenKsMerchantClient("https://open.kwaixiaodian.com", "", "");


        KsMerchantOrderDeliverRequest deliverRequest = new KsMerchantOrderDeliverRequest();
        deliverRequest.setExpressCode(1);
        deliverRequest.setExpressNo("1");
        deliverRequest.setOrderId(1L);
        deliverRequest.setAccessToken("");
        deliverRequest.setTimestamp(1618664033801L);

        KsMerchantResponse response = tokenKsMerchantClient.execute(deliverRequest);
        System.out.println(response);

    }

}
