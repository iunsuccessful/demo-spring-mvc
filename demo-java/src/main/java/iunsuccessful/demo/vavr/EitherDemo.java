package iunsuccessful.demo.vavr;

import io.vavr.control.Either;

import java.util.Random;

/**
 * 两者当中任意一个
 * 比如这个可以用来判断，如果是手机号是虚拟号怎么处理，真实手机号怎么处理
 * 依韵 2021/12/26
 */
public class EitherDemo {

    static Random random = new Random();

    public static void main(String[] args) {

        for (int j = 0; j < 5; j++) {
            Either<String, Integer> value = compute().right().map(i -> i * 2).toEither();
            if (value.isRight()) {
                System.out.println(value);
            }
        }


    }

    private static Either<String, Integer> compute() {
        int a = random.nextInt(10);
        System.out.println(a);
        return a > 5 ? Either.left("随机数大于 5")
                : Either.right(a);
    }

}
