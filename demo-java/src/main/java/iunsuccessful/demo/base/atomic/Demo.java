package iunsuccessful.demo.base.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by LiQZ on 2017/10/13.
 */
public class Demo {

    private AtomicInteger var1 = new AtomicInteger(99);

    public void test() {
        int var2 = 88; // zk 取
//        if (var1.compareAndSet(var1.intValue(), var2)) {
//            // TODO clear cache
//            System.out.println("clear cache");
//        }
        if (var1.intValue() != var1.updateAndGet(operand -> var2)) {
            // TODO clear cache
            System.out.println("clear cache");
        }
        System.out.println(var1);
    }

    public static void main(String[] args) {
        new Demo().test();
    }

}
