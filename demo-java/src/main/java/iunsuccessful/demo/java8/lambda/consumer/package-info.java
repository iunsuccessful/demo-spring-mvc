/**
 * 理解：延迟执行
 * <code>
 // Consumer<String> consumer = System.out::println;
 Consumer<String> consumer = new Consumer<String>() {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
 };
 consumer.accept("hello");
 * </code>
 * 使用场景：
 *
 *
 * @author LiQZ on 2016/9/30.
 */
package iunsuccessful.demo.java8.lambda.consumer;