package org.example;

import org.example.provider.DefaultPublisher;
import org.example.subscriber.BusinessSubscriber;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        DefaultPublisher<String> publisher = new DefaultPublisher<>();
        BusinessSubscriber<String> subscriber = new BusinessSubscriber<>();
        publisher.subscribe(subscriber);
        int[] data = {1, 2, 3, 4, 5};
        for (int i : data) {
            publisher.publish(String.valueOf(i));
        }
    }
}
