package iunsuccessful.demo.base.aop;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;

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
//        jdkBase();
        guavaBase();

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

        IFoo foo = (IFoo) Proxy.newProxyInstance(
                IFoo.class.getClassLoader(),
                new Class<?>[] { IFoo.class },
                invocationHandler);

        foo.sayHello();
    }

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

interface IFoo {

    void sayHi();

    void sayHello();

}

class Foo implements IFoo {

    @Override
    public void sayHi() {
        System.out.println("Hi~");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello!");
        sayHi();
    }
}
