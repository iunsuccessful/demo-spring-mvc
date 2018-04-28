package iunsuccessful.demo.guava.demo;

import com.google.common.base.Joiner;

/**
 * Created by LiQZ on 2018/1/22.
 */
public class JoinDemo2 {

    public static void main(String[] args) {
        Joiner joiner = Joiner.on(";").skipNulls();

    }

}
