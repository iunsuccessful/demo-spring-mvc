package iunsuccessful.demo.vavr;

import io.vavr.control.Try;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 依韵 2022/4/13
 */
public abstract class Try2<T> {


    public static <T> Try2<T> of(Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        try {
            return new Success<>(supplier.get());
        } catch (Throwable t) {
            return new Failure<>(t);
        }
    }

    public static <R, T> Try2<T> of(Function<R, T> function, R value) {
        Objects.requireNonNull(function, "supplier is null");
        try {
            return new Success<>(function.apply(value));
        } catch (Throwable t) {
            return new Failure<>(t);
        }
    }

    public abstract T get();


    /**
     * A succeeded Try.
     *
     * @param <T> component type of this Success
     * @deprecated will be removed from the public API
     */
    @Deprecated
    public static final class Success<T> extends Try2<T> implements Serializable {

        private static final long serialVersionUID = 1L;

        private final T value;

        /**
         * Constructs a Success.
         *
         * @param value The value of this Success.
         */
        private Success(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }

        public Throwable getCause() {
            throw new UnsupportedOperationException("getCause on Success");
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean isFailure() {
            return false;
        }

        public boolean isSuccess() {
            return true;
        }

        public boolean equals(Object obj) {
            return (obj == this) || (obj instanceof Success && Objects.equals(value, ((Success<?>) obj).value));
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }

        public String stringPrefix() {
            return "Success";
        }

        @Override
        public String toString() {
            return stringPrefix() + "(" + value + ")";
        }
    }

    /**
     * A failed Try.
     *
     * @param <T> component type of this Failure
     * @deprecated will be removed from the public API
     */
    @Deprecated
    public static final class Failure<T> extends Try2<T> implements Serializable {

        private static final long serialVersionUID = 1L;

        private final Throwable cause;

        /**
         * Constructs a Failure.
         *
         * @param cause A cause of type Throwable, may not be null.
         * @throws NullPointerException if {@code cause} is null
         * @throws Throwable            if the given {@code cause} is fatal, i.e. non-recoverable
         */
        private Failure(Throwable cause) {
            Objects.requireNonNull(cause, "cause is null");
//            if (isFatal(cause)) {
//                sneakyThrow(cause);
//            }
            this.cause = cause;
        }

        public T get() {
            // return sneakyThrow(cause);
            throw new RuntimeException(cause);
        }

        public Throwable getCause() {
            return cause;
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean isFailure() {
            return true;
        }

        public boolean isSuccess() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj == this) || (obj instanceof Failure && Arrays.deepEquals(cause.getStackTrace(), ((Failure<?>) obj).cause.getStackTrace()));
        }

//        @Override
//        public String stringPrefix() {
//            return "Failure";
//        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(cause.getStackTrace());
        }

        @Override
        public String toString() {
            // return stringPrefix() + "(" + cause + ")";
            return super.toString();
        }

    }


}
