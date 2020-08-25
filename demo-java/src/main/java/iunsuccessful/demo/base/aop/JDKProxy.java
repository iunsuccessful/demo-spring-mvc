package iunsuccessful.demo.base.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * JDK Proxy 不需要实现接口的
 * 依韵 2020/3/31
 */
public class JDKProxy {

    public static void main(String[] args) {

        JDKProxy jdkProxy = new JDKProxy();
        IFoo foo = jdkProxy.target(IFoo.class);

        String test = foo.sayHello();
        System.out.println(test);
        foo.sayHi();

    }

    public <T> T target(Class<T> clazz) {

        // 利用反射判断必须是个接口
        checkArgument(clazz.isInterface(), "@XXX 必须是接口");

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // do something
                System.out.println("do something...");
                return "Hello!";
            }
        };

        return clazz.cast(Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class<?>[] { clazz },
                handler));
    }



}
