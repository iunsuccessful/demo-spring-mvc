package iunsuccessful.demo.vavr;

import java.util.function.Predicate;

import static io.vavr.API.*;

/**
 * 依韵 2021/12/25
 */
public class PatternMatchingDemo {

    public static void main(String[] args) {
        // demo1();
        demo2();
    }


    public static void demo2() {

        String one = "一";
        String two = "二";

        String s = Match(one).of(
                Case($(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return "一".equals(s);
                    }
                }), "壹"),
                Case($("二"), "貮"),
                Case($(), "?")
        );

        System.out.println(s);

    }

    public static void demo1() {
        for (int i = 0; i < 4; i++) {
            String s = Match(i).of(
                    Case($(1), "one"),
                    Case($(2), "two"),
                    Case($(), "?")
            );
            System.out.println(s);
        }
    }

}
