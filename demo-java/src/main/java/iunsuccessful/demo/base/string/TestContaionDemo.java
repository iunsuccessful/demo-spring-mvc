package iunsuccessful.demo.base.string;

/**
 * 依韵 2019-09-21
 */
public class TestContaionDemo {

    public static void main(String[] args) {
        String a = "123|2";

        Long b = 123L;

        System.out.println(new StringBuilder("|").append(a).append("|").indexOf("|"+b+"|") > -1);

    }

}
