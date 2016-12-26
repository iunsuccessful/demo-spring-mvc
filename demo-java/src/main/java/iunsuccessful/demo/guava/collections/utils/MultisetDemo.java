package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.function.Consumer;

/**
 * Created by LiQZ on 2016/12/5.
 */
public class MultisetDemo {

    public static void main(String[] args) {
        Multiset<Integer> multiset = HashMultiset.create();
        multiset.add(123);
        multiset.add(123);
        multiset.add(123);
        multiset.add(1234);
        multiset.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(multiset.count(integer));
            }
        });

    }

}
