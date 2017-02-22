package iunsuccessful.demo.guava.demo;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * 除了用 Guava 的 Joiner 外，Stream.collect(Collectors.joining(","));
 *
 * @see iunsuccessful.demo.java8.lambda.StreamJoinDemo
 * Created by LiQZ on 2016/12/21.
 */
public class JoinDemo {

    public static void main(String[] args) {
        Joiner joiner = Joiner.on(" or ").skipNulls();
        StringBuilder condition = new StringBuilder();
        System.out.println(joiner.join(condition, null, "brandID=1", null));

        List<String> slist = new ArrayList<>();
        slist.add("web");
        slist.add("app");
        slist.add("pc");
        String out = Joiner.on(",").join(slist);
        System.out.println(out);
    }

}
