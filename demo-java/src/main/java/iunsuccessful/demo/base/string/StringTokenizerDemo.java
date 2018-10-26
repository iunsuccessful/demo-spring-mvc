package iunsuccessful.demo.base.string;

import java.util.StringTokenizer;

/**
 * Note: 分隔符是或的关系 " ," 空格或逗号
 * Create By LiQZ 2018/8/1
 */
public class StringTokenizerDemo {

    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("We are learning , ##,Java Program", " ,");
        System.out.printf("本句共有 %d 个单词\n", stringTokenizer.countTokens());
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
    }

}
