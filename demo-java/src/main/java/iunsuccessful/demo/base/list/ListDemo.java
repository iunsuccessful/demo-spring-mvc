package iunsuccessful.demo.base.list;

import java.util.ArrayList;
import java.util.List;

/**
 * List 扩容，被始为 2 的话，下次是 4, 8, 16 以初始大小成倍扩容
 * Created by LiQZ on 2018/1/16.
 */
public class ListDemo {

    public static void main(String[] args) {

        List<Integer> ids = new ArrayList<>(2);

        ids.add(1);
        ids.add(2);
        ids.add(3);

        System.out.println(ids);

    }


}
