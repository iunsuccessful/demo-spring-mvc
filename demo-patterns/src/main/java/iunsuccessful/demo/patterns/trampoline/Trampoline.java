package iunsuccessful.demo.patterns.trampoline;

import java.util.stream.Stream;

/**
 * 依韵 2019/11/27
 */
public interface Trampoline<T> {

    T get();

    /**
     * 这样写应该是跟 T 有关系，直接用 get 的话，返回的是当前 Trampoline 的类型
     */
    default T result() {
        return get();
    }

    /**
     * 算法核心，怎么把递归展开就看这里
     */
    default Trampoline<T> jump() {
        return this;
    }

    /**
     * check is complete
     * stream 里迭代循环
     */
    default boolean complete() {
        return true;
    }

    /**
     * 对象转换成接口
     */
    static <T> Trampoline<T> done(final T result) {
        return () -> result;
    }

    static <T> Trampoline<T> more(final Trampoline<Trampoline<T>> trampoline) {

        return new Trampoline<T>() {
            @Override
            public boolean complete() {
                return false;
            }

            @Override
            public Trampoline<T> jump() {
                return trampoline.result();
            }

            @Override
            public T get() {
                return trampoline(this);
            }

            T trampoline(final Trampoline<T> trampoline) {
                return Stream.iterate(trampoline, Trampoline::jump)
                        // 完成的只有 done 的那个，其他的都是 jump
                        .filter(Trampoline::complete)
                        .findFirst()
                        .map(Trampoline::result)
                        .orElseThrow();
            }
        };
    }
}
