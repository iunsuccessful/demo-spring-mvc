package iunsuccessful.demo.vavr;

import io.vavr.collection.CharSeq;

import java.util.function.Predicate;

/**
 * 依韵 2021/12/26
 */
public class CharSeqDemo {

    private static final String VALID_NAME_CHARS = "[a-zA-Z ]";

    public static void main(String[] args) {
        String name = "Alex Mahone";
        Boolean result = CharSeq.of(name).replaceAll(VALID_NAME_CHARS, "").transform(CharSeq::isEmpty);
        System.out.println(result);
        String resultName = CharSeq.of(name).filter(character -> !character.equals(' ')).toString();
        System.out.println(resultName);
    }

}
