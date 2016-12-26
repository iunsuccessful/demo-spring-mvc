package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;

import java.util.List;

import static iunsuccessful.demo.common.utils.PrintUtils.print;


/**
 * @author LiQZ on 2016/6/7.
 */
public class ListDemo {

    public static void main(String[] args) {
        deleteMulti();
    }


    /**
     * 只能去除连续的重复数据
     * peek: 窥视
     */
    static void deleteMulti() {
        List<Users> result = Lists.newArrayList();
        PeekingIterator<Users> iter = Iterators.peekingIterator(Users.getMulitList().iterator());
        while (iter.hasNext()) {
            Users current = iter.next();
            while (iter.hasNext() && iter.peek().getId() == current.getId()) {
                //跳过重复的元素
                iter.next();
            }
            result.add(current);
        }
        print(result);
    }

}
