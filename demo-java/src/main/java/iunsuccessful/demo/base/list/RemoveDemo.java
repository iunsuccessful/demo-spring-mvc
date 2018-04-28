package iunsuccessful.demo.base.list;

import java.util.ArrayList;
import java.util.List;

/**
 * list<integer>  remove 测试
 * Created by LiQZ on 2018/3/22.
 */
public class RemoveDemo {

    public static void main(String[] args) {
        List<Integer> productIds = new ArrayList<>();
        productIds.add(1);
        productIds.add(2);
        productIds.add(3);
        productIds.add(4);
        System.out.println(productIds);
        productIds.remove(1);
        System.out.println(productIds);
        productIds.remove(new Integer(1));
        System.out.println(productIds);
    }

}
