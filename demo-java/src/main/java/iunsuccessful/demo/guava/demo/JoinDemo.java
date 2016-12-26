package iunsuccessful.demo.guava.demo;

import com.google.common.base.Joiner;

/**
 * Created by LiQZ on 2016/12/21.
 */
public class JoinDemo {

    public static void main(String[] args) {
        Joiner joiner = Joiner.on(" or ").skipNulls();
        StringBuilder condition = new StringBuilder();
        System.out.println(joiner.join(condition, null, "brandID=1"));
    }

}
