package iunsuccessful.demo.practice;

import java.util.function.Supplier;

/**
 * @author LiQZ on 2016/9/22.
 */
public class Precondition {

    public static <T> T checkCondition(boolean expression, Supplier<T> supplier) {
        if (expression) {
            return supplier.get();
        }
        return null;
    }

    /**
     * 如果满足条件，就执行，这样写好吗？
     * 肯定没有下面这个好，主要是容易理解，里面做一些与整体思路无关的操作
     * if expression { }
     */
    public static void main(String[] args) {
        int i = 0;
        checkCondition(i < 3, new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return null;
            }
        });
    }

}
