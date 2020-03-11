package iunsuccessful.demo.patterns.retry;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * 依韵 2020/1/20
 */
public final class Retry2<T> implements BusinessOperation<T> {

    private BusinessOperation<T> op;
    private int maxAttempts;
    private long delay;
    private AtomicInteger attempts;
    private final Predicate<Exception> ignoreTests;

    @SafeVarargs
    public Retry2(BusinessOperation<T> op,
                  Integer maxAttempts,
                  Long delay,
                  Predicate<Exception>... ignoreTests) {
        this.op = op;
        this.maxAttempts = maxAttempts;
        this.delay = delay;
        this.attempts = new AtomicInteger();
        this.ignoreTests = Arrays.stream(ignoreTests).reduce(Predicate::or).orElse(e -> false);
    }

    @Override
    public T perform() throws BusinessException {
        do {
            try {
                return this.op.perform();
            } catch (Exception e) {

                // 如果重试次数达到设定，或者抛出幂等之类异常，就不用重试了。
                if (this.attempts.incrementAndGet() >= maxAttempts || ignoreTests.test(e)) {
                    throw e;
                }

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ie) {
                    // ignore
                }
            }

        } while (true);

    }

}
