package iunsuccessful.demo.apache.collection;

import iunsuccessful.demo.common.utils.PrintUtils;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

/**
 * 统计数量
 * 底层是通过 Map 保存数据，key 为元素，value 为数量；另外通过 set 实现 uniqueSet
 * Create By LiQZ 2018/8/30
 */
public class BagDemo {

    public static void main(String[] args) {
        Bag bag = new HashBag();
        bag.add(11);
        bag.add(11);
        bag.add(11);
        bag.add(12);
        PrintUtils.printBag(bag);
        System.out.println("bag.getCount(11) = " + bag.getCount(11));
    }

}
