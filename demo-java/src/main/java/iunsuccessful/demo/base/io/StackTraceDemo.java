package iunsuccessful.demo.base.io;

/**
 * 如何打印调用链
 * Created by LiQZ on 2018/4/24.
 */
public class StackTraceDemo {

    static {
        System.out.println("static area");
    }

    public StackTraceDemo() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement);
            System.out.println(stackTraceElement.getMethodName());
            System.out.println(stackTraceElement.getClassName());
            if ("main".equals(stackTraceElement.getMethodName())) {
                try {
                    System.out.println(Class.forName(stackTraceElement.getClassName()));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
