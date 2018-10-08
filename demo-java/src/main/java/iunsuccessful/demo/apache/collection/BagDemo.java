package iunsuccessful.demo.apache.collection;

import iunsuccessful.demo.common.utils.PrintUtils;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

/**
 * 统计数量
 * Create By LiQZ 2018/8/30
 */
public class BagDemo {

    public static void main(String[] args) {
        Bag bag = new HashBag();
        bag.add(11);
        bag.add(11);
        bag.add(11);
        PrintUtils.printBag(bag);
    }

}
