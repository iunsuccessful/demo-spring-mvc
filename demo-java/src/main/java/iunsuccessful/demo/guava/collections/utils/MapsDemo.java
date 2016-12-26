package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;

import java.util.List;
import java.util.Map;

import static iunsuccessful.demo.common.utils.PrintUtils.print;

/**
 * @author LiQZ on 2016/6/7.
 */
public class MapsDemo {

    public static void main(String[] args) {
//        mapsUnique();
        mapMultiIndex();
    }

    /** maps */

    /**
     * Note: 多个 key 会报错
     */
    static void mapsUnique() {
        List<Users> users = Lists.newArrayList();
        users.add(new Users(1, "li"));
        users.add(new Users(2, "zhang"));
        users.add(new Users(3, "wang"));
        Map<Integer, Users> userMap = Maps.uniqueIndex(users, Users::getId);
        print(userMap);
    }

    /**
     * Multimap 可以多个键
     * asMap 后返回的是个数组
     * {key: 1, value: [iunsuccessful.demo.guava.collections.utils.MapsDemo$Users@11028347]}
     * {key: 2, value: [iunsuccessful.demo.guava.collections.utils.MapsDemo$Users@14899482, iunsuccessful.demo.guava.collections.utils.MapsDemo$Users@21588809]}
     */
    static void mapMultiIndex() {
        List<Users> users = Lists.newArrayList();
        users.add(new Users(1, "li"));
        users.add(new Users(2, "zhang"));
        users.add(new Users(2, "wang"));
        ImmutableListMultimap<Integer, Users> userMap = Multimaps.index(users, Users::getId);
        print(userMap);
    }



}
