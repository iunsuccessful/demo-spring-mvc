package iunsuccessful.demo.java9;

import java.util.Arrays;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * Create By LiQZ 2018/12/28
 */
public class FlowApiDemo {



    public static void main(String[] args) {

        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        publisher.subscribe(new Flow.Subscriber<>(){

            private Integer sum = 0;

            // begin
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println(subscription);
                subscription.request(2);
            }

            // accept
            @Override
            public void onNext(Integer item) {
                System.out.println(item);
                sum += item;
            }

            @Override
            public void onError(Throwable throwable) {
            }

            // end
            @Override
            public void onComplete() {
                System.out.println(sum);
            }
        });

        Arrays.asList(3, 4).forEach(publisher::submit);
        System.out.println("before close");
        publisher.close();
    }


}
