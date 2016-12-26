package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimaps;

/**
 * @author LiQZ on 2016/6/7.
 */
public class SetDemo {

    public static void main(String[] args) {
        multiSetCount();
    }

    /**
     * 统计 id = 2 的 User 数量
     */
    static void multiSetCount() {
        HashMultiset multiset = HashMultiset.create();
        multiset.addAll(Multimaps.index(Users.getMulitList(), Users::getId).keys());
        System.out.println(multiset.count(2));
    }



}
