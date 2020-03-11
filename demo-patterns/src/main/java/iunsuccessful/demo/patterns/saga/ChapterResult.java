package iunsuccessful.demo.patterns.saga;

/**
 * 依韵 2020/1/17
 */
public class ChapterResult<K> {

    private K value;

    private State state;

    public K getValue() {
        return value;
    }

    ChapterResult(K value, State state) {
        this.value = value;
        this.state = state;
    }

    public boolean isSuccess() {
        return state == State.SUCCESS;
    }

    public static <K> ChapterResult<K> success(K val) {
        return new ChapterResult<>(val, State.SUCCESS);
    }

    public static <K> ChapterResult<K> failure(K val) {
        return new ChapterResult<>(val, State.FAILURE);
    }

    public enum State {
        SUCCESS, FAILURE;
    }


}
