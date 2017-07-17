package iunsuccessful.demo.base.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 原子操作
 * Created by LiQZ on 2017/6/8.
 */
public class AtomicBooleanDemo {

    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(false);
        System.out.println(flag.compareAndSet(false, true));
        flag.set(false);
        System.out.println(flag.compareAndSet(false, true));
        System.out.println(flag.compareAndSet(false, true));
    }


}
