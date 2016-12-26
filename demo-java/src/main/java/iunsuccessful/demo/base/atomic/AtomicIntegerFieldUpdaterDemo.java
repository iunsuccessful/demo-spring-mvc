package iunsuccessful.demo.base.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 保证字段更新的原子性
 * @author LiQZ on 2016/9/23.
 */
public class AtomicIntegerFieldUpdaterDemo {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterDemo> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterDemo.class, "a");

    public volatile int a = 100;

    private static AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();

    public static void main(String[] args) {
        for(int i=0; i<100;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(updater.compareAndSet(demo, 100, 120)){
                        System.out.print("已修改 ");
                    } else {
                        System.out.print("修改失败 ");
                    }
                }
            });
            t.start();
        }
    }



}
