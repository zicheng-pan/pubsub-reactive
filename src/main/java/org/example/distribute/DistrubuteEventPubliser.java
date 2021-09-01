package org.example.distribute;

import org.I0Itec.zkclient.ZkClient;
import org.example.Publisher;
import org.example.Subscriber;
import org.example.provider.DefaultPublisher;

import java.util.EventObject;

public class DistrubuteEventPubliser implements Publisher<EventObject> {

    DefaultPublisher<EventObject> publisher = new DefaultPublisher<>();


    public DistrubuteEventPubliser(ZkClient zkClient, String path) {
        publisher.subscribe(new DistributeEventEmmiter(zkClient, path));
    }

    @Override
    public void subscribe(Subscriber<? super EventObject> var1) {
        publisher.subscribe(var1);
    }

    @Override
    public void subscribe(org.reactivestreams.Subscriber s) {
        publisher.subscribe(s);
    }

    public void publish(EventObject eventObject) {
        publisher.publish(eventObject);
    }
}
