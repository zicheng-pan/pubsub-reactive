package org.example;

import org.example.provider.DecoratingSubscriber;

public class SubscriptionAdatper implements Subscription {

    private DecoratingSubscriber decoratingSubscriber;

    private boolean iscancle = false;

    public SubscriptionAdatper(org.reactivestreams.Subscriber subscriber) {
        decoratingSubscriber = new DecoratingSubscriber(subscriber);
    }

    @Override
    public void request(long n) {
        if (n < 1) {
            throw new IllegalArgumentException("The number of elements to requests must be more than zero!");
        }
//        this.subscriber.setMaxRequest(n);
    }

    @Override
    public void cancel() {
        this.iscancle = true;
        System.out.println("subscriber cancel!!!");
    }

    public Subscriber getSubscriber() {
        return decoratingSubscriber;
    }
}
