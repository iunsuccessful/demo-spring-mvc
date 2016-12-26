package iunsuccessful.demo.guava.event;

import com.google.common.eventbus.Subscribe;

/**
 * @author LiQZ on 2016/3/25.
 */
public class EventListener {

    private int lastMessage = 0;

    @Subscribe
    public void testEventListener(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println("lastMessage: " + lastMessage);
    }

    public int getLastMessage() {
        return lastMessage;
    }

    public static void main(String[] args) {
        com.google.common.eventbus.EventBus eventBus = new com.google.common.eventbus.EventBus();
        eventBus.register(new EventListener());

        TestEvent testEvent = new TestEvent(222);
        eventBus.post(testEvent);

    }

}
