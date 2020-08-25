package iunsuccessful.demo.base.aop;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 分别使用 jdk, cglib, aspectJ, guava
 * 实现在方法前后打印 begin...  end.
 * Create By LiQZ 2018/7/11
 */
public class DemoProxy {

    public static void main(String[] args){
//        final IFoo f = new Foo();
//        DemoImplProxy dip = new DemoImplProxy(f);
//        ((IFoo) dip.getO()).sayHello();
//        jdkBase();
//        guavaBase();
        cglibProxy();

    }

    private static void jdkBase() {
        final IFoo f = new Foo();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("begin...");
                method.invoke(f, args);
                System.out.println("end.");
                return null;
            }
        };

//        IFoo.class.cast  => (IFoo)

        IFoo foo = (IFoo) Proxy.newProxyInstance(
                IFoo.class.getClassLoader(),
                new Class<?>[] { IFoo.class },
                invocationHandler);

        foo.sayHello();
    }

    /**
     * guava 也需要有接口
     */
    private static void cjlibBase() {

    }

    private static void guavaBase() {
        final IFoo f = new Foo();
//        AbstractInvocationHandler invocationHandler = new AbstractInvocationHandler() {
//            @Override
//            protected Object handleInvocation(Object o, Method method, Object[] objects) throws Throwable {
//                System.out.println("begin...");
//                method.invoke(f, objects);
//                System.out.println("end.");
//                return null;
//            }
//        };
//
//        IFoo foo = Reflection.newProxy(IFoo.class, invocationHandler);
//
//        foo.sayHello();

        DemoImplProxy dip = new DemoImplProxy(f);
        // 思考：为什么调用 sayHi 方法，没有被增强
        ((IFoo) dip.getO()).sayHello();

    }

    public static void cglibProxy() {
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(Foo.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new NoExceptionInterceptor());
        // 创建代理对象
        Foo proxy = (Foo)enhancer.create();

        proxy.sayHello();
    }

}

class DemoImplProxy {

    private Object obj;

    public DemoImplProxy(final IFoo f) {
        AbstractInvocationHandler invocationHandler = new AbstractInvocationHandler() {
            @Override
            protected Object handleInvocation(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("begin...");
                method.invoke(f, objects);
                System.out.println("end.");
                return null;
            }
        };
        this.obj = Reflection.newProxy(IFoo.class, invocationHandler);
    }

    public Object getO() {
        return obj;
    }
}

class NoExceptionInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======插入前置通知======");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("======插入后者通知======");
        return object;
    }

}


interface IFoo {

    void sayHi();

    String sayHello();

}

class Foo implements IFoo {

    @Override
    public void sayHi() {
        System.out.println("Hi~");
    }

    @Override
    public String sayHello() {
        System.out.println("Hello!");
        sayHi();
        return "Hello!";
    }
}
