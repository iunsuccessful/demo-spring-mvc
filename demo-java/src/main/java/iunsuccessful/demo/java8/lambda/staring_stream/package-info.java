/**
 *
 * 使用
 * <code>
 new Supplier<String>() {
    @Override
        public String get() {
            return null;
        }
 };
 * </code>
 *
 * java 8 supplier 使用场景演示
 *
 * 1. 生成器 {@link iunsuccessful.demo.java8.lambda.supplier.FibonacciStream}
 * 2. 工厂模式提供创建者 <code>Car::new</code>
 *
 * @author LiQZ on 2016/9/30.
 */
package iunsuccessful.demo.java8.lambda.staring_stream;