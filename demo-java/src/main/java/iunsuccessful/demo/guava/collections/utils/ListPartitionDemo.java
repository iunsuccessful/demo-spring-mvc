package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.Lists;
import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.List;

/**
 * 对 List 进行切割
 * Created by LiQZ on 2017/2/13.
 */
public class ListPartitionDemo {

    public static void main(String[] args) {

        List<Users> users = Users.getList();
//按每50个一组分割
        List<List<Users>> parts = Lists.partition(users, 2);
        parts.forEach(PrintUtils::print);

        users.clear();
        PrintUtils.print(users);
        users.add(new Users(1, "li"));
        PrintUtils.print(users);

    }


}
