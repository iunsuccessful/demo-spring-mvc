package iunsuccessful.demo.base.aop.service;

/**
 * Create By LiQZ 2019/1/9
 */
public class SayHelloServiceImpl implements SayHelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello!~");
        sayHi();
    }

    @Override
    public void sayHi() {
        System.out.println("Hi!~~");
    }
}
