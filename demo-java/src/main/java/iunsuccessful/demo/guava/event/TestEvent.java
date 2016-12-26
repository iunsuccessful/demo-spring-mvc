package iunsuccessful.demo.guava.event;

/**
 * @author LiQZ on 2016/3/25.
 */
public class TestEvent {

    private final int message;

    public TestEvent(int message) {
        this.message = message;
        System.out.println("event message: " + message);
    }

    public int getMessage() {
        return message;
    }
}
