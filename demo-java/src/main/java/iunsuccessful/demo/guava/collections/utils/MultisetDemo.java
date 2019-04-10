package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by LiQZ on 2016/12/5.
 */
public class MultisetDemo {

    public static void main(String[] args) {
        Multiset<Integer> multiset = HashMultiset.create();
        multiset.add(123, 2);
        multiset.add(123);
        multiset.add(123);
        multiset.add(1234);

        System.out.println(multiset.count(123));

        System.out.println("element size");
        System.out.println(multiset.elementSet().size());
        System.out.println(multiset.entrySet().size());
        multiset.elementSet().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.printf("%d -> %d\n",integer, multiset.count(integer));
            }
        });

        // 这里也是
//        Iterator<Integer> iterator = multiset.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        multiset.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(multiset.count(integer));
//            }
//        });



    }

}
