package iunsuccessful.demo.vavr;

import io.vavr.CheckedFunction2;
import io.vavr.Function2;

import java.util.function.Function;

/**
 * Vavr 提供了函数式接口 Function0、Function1 到 Function8，可以描述最多接受 8 个参数的函数。
 * 但是比较难受的是这些接口的方法 apply 不能抛出异常。如果需要抛出异常，
 * 可以使用对应的接口 CheckedFunction0、CheckedFunction1 到 CheckedFunction8。
 * 依韵 2021/12/26
 */
public class CheckedFunction0Demo {

    public static void main(String[] args) {

        try {
            // 感觉才会抛异常啊
            Function2<Integer, Integer, Integer> div = (a, b) -> a/b;
            System.out.println(div.apply(10, 0));
            System.out.println("end");
//            CheckedFunction2<Integer, Integer, Integer> div2 = (a, b) -> a / b;
//            System.out.println(div2.apply(10, 0));
//            System.out.println("end");
        }  catch (Throwable throwable) {
            System.out.println("fail");
        }


    }
}
