package iunsuccessful.demo.base.aop.annotations;

import java.lang.reflect.Method;

/**
 * 如何拦截调用链的全部 annotation
 * Create By LiQZ 2019/1/9
 */
public class DemoTestProcess {

    public static void main(String[] args) {
        for (Method m: DemoTestProcess.class.getDeclaredMethods()) {
            DemoTest demoTest = m.getAnnotation(DemoTest.class);
            if (demoTest != null) {
                System.out.println(demoTest.value());
            }

        }
    }

    @DemoTest("test1")
    public void testDemo1() {
        testDemo2();
    }

    @DemoTest("test2")
    public void testDemo2() {
        System.out.println("test2");
    }

}
