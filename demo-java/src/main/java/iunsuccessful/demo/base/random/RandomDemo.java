package iunsuccessful.demo.base.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by LiQZ on 2018/2/6.
 */
public class RandomDemo {

    public static void main(String[] args) {
        shuffleDemo();
    }

    public static void shuffleDemo() {
        Random random = new Random();
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        Collections.shuffle(list);
        System.out.println(list);
    }

}
