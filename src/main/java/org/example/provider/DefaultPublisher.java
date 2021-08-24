package org.example.provider;

import org.example.Publisher;
import org.example.Subscriber;
import org.example.SubscriptionAdatper;

import java.util.ArrayList;
import java.util.List;

public class DefaultPublisher<T> implements Publisher<T> {

    List<Subscriber> subscribers = new ArrayList<>();


    public void publish(T data) {
        subscribers.forEach(subscriber -> {
            subscriber.onNext(data);
        });
    }


    @Override
    public void subscribe(Subscriber<? super T> var1) {
        SubscriptionAdatper subscription = new SubscriptionAdatper(var1);
        var1.onSubscribe(subscription);
        subscribers.add(subscription.getSubscriber());
    }

    @Override
    public void subscribe(org.reactivestreams.Subscriber s) {
        SubscriptionAdatper subscription = new SubscriptionAdatper(s);
        s.onSubscribe(subscription);
        subscribers.add(subscription.getSubscriber());
    }
}
