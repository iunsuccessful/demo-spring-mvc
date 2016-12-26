package iunsuccessful.demo.java8.lambda;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author LiQZ on 2016/11/1.
 */
public class RandomOfList {

    public static void main(String[] args) {
//        randomOfList();
        randomOfList2();
//        randomOfShuffle();
    }

    /**
     * 这里面有重复的
     */
    private static void randomOfList() {
        List<String> sourceWords = new ArrayList<>();
        sourceWords.add("sss");
        sourceWords.add("BB");
        sourceWords.add("CC");
        sourceWords.add("DD");
        sourceWords.add("EE");
        sourceWords.add("FF");
        sourceWords.add("FG");
        sourceWords.add("EG");
        sourceWords.add("AA");
        Random rand = new Random();
        List<String> wordList = rand
                .ints(3, 0, sourceWords.size())
                .mapToObj(sourceWords::get)
                .collect(Collectors.toList());
        PrintUtils.print(wordList);
    }

    /**
     * 这里面有重复的
     */
    private static void randomOfList2() {
        List<String> sourceWords = new ArrayList<>();
        sourceWords.add("AA");
        sourceWords.add("BB");
        sourceWords.add("CC");
        sourceWords.add("DD");
        sourceWords.add("EE");
        sourceWords.add("FF");
        sourceWords.add("GG");
        sourceWords.add("HH");
        sourceWords.add("II");
        Random rand = new Random();
        List<String> wordList = rand
                .ints(0, sourceWords.size())
                .distinct()
                .limit(Math.min(20, sourceWords.size()))
                .mapToObj(sourceWords::get)
                .collect(Collectors.toList());
        PrintUtils.print(wordList);
    }

    private static void randomOfShuffle() {
        List<String> sourceWords = new ArrayList<>();
        sourceWords.add("AA");
        sourceWords.add("BB");
        sourceWords.add("CC");
        sourceWords.add("DD");
        sourceWords.add("EE");
        sourceWords.add("FF");
        sourceWords.add("GG");
        sourceWords.add("HH");
        sourceWords.add("II");
        List<String> wordList = sourceWords.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), collected -> {
                    Collections.shuffle(collected); // 洗牌
                    return collected.stream();
                }))
                .limit(5)
                .collect(Collectors.toList());
        PrintUtils.print(wordList);
    }

}
