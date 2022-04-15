package iunsuccessful.demo.concurrent;

import iunsuccessful.demo.common.domain.Point;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference是作用是对”对象”进行原子操作。
 * 提供了一种读和写都是原子性的对象引用变量。原子意味着多个线程试图改变同一个AtomicReference(例如比较和交换操作)将不会使得AtomicReference处于不一致的状态。
 * 依韵 2022/3/2
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {

        AtomicReference<Point> pointAtomicReference = new AtomicReference<>();
        pointAtomicReference.set(new Point(10, 20));

        pointAtomicReference.get().setX(10);

    }



}
