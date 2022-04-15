package iunsuccessful.demo.vavr;

import io.vavr.CheckedFunction2;

import java.io.IOException;
import java.util.Random;
import java.util.function.BiFunction;

/**
 * Vavr 提供了函数式接口 Function0、Function1 到 Function8，可以描述最多接受 8 个参数的函数。
 * 但是比较难受的是这些接口的方法 apply 不能抛出异常。如果需要抛出异常，
 * 可以使用对应的接口 CheckedFunction0、CheckedFunction1 到 CheckedFunction8。
 *
 * 这里的异常不是像 RuntimeException 这样的隐式异常，而且显示的异常。如 IOException；RuntimeException 都会抛出的
 *
 * 依韵 2021/12/26
 */
public class CheckedFunction0Demo {

    public static void main(String[] args) {

        try {
            // 这样写不可以
//            Function2<String, String, String> div = CheckedFunction0Demo::randomException;
//            System.out.println(div.apply("10", "0"));
//            System.out.println("end");
            // 这样写可以
            CheckedFunction2<String, String, String> div2 = CheckedFunction0Demo::randomException;
            System.out.println(div2.apply("10", "0"));
            System.out.println("end");

            // java 8 的 Function 也是不可以抛出显示异常的
            // BiFunction<String, String, String> div3 = CheckedFunction0Demo::randomException;

        } catch (Throwable throwable) {
            System.out.println(throwable);
            System.out.println("fail");
        }

    }

    public static String randomException(String a, String b) throws IOException {
        Random random = new Random();
        if (random.nextInt(10) > 5) {
            throw new IOException("IOException");
        }
        return a + b;
    }


}
