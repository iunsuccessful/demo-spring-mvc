package iunsuccessful.demo.java8.lambda.str;

import iunsuccessful.demo.common.utils.PrintUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 给定单词列表["Hello","World"]，返回列表["H","e","l", "o","W","r","d"] 用 Lambda 实现
 * 技能点：区别 map 与 flatMap（flat意思：平的）
 *
 * map 返回值 String[]，会被封装成多个 Stream<String[]>
 * flatMap 返回值直接可以写成 Stream<String> 会把多个 Stream<String[]> 合并成一个
 */
public class SpiltToListDemo {

    private static final String[] strArray = {"Hello", "World"};

    public static void main(String[] args){
        // mao 方式
        method1();
        method2();
    }

    private static void method1() {

        String[] arrs = Arrays.asList(strArray).stream().map(new Function<String, String[]>() {

            @Override
            public String[] apply(String s) {
                return s.split("");
            }

        }).reduce(new BinaryOperator<String[]>() {
            @Override
            public String[] apply(String[] strings, String[] strings2) {
                String[] arrays = new String[strings.length + strings2.length];
                int i = 0;
                for (; i < strings.length; i++) {
                    arrays[i] = strings[i];
                }
                for (; i - strings.length < strings2.length; i++) {
                    arrays[i] = strings2[i - strings.length];
                }
                return arrays;
            }
        }).get();

        PrintUtils.print(arrs);

    }

    private static void method2() {
        List<String> arrs = Arrays.asList(strArray).stream().flatMap(new Function<String, Stream<String>>() {
            @Override
            public Stream<String> apply(String s) {
                // 数据变流
                return Arrays.stream(s.split(""));
            }
        }).collect(toList());

        PrintUtils.print(arrs);

    }

}
