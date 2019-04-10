package iunsuccessful.demo.base.aop.cglib;

import iunsuccessful.demo.base.aop.service.SayHelloService;
import iunsuccessful.demo.base.aop.service.SayHelloServiceImpl;

/**
 * Create By LiQZ 2019/1/9
 */
public class CglibDemo {

    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy();
        SayHelloService sayHelloService = (SayHelloService) proxy.getProxy(SayHelloServiceImpl.class);
        sayHelloService.sayHello();
    }

}
