package iunsuccessful.demo.apache.lang3;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Create By LiQZ 2018/7/27
 */
public class PairDemo {

    public static void main(String[] args){
        Pair pair = new ImmutablePair(1, "one");

        System.out.println(pair);
        System.out.println(((ImmutablePair) pair).left);
    }

}
