package org.example.distribute;

import org.I0Itec.zkclient.ZkClient;
import org.example.Subscriber;
import org.reactivestreams.Subscription;

import java.util.EventObject;

public class DistributeEventEmmiter implements Subscriber<EventObject> {


    private ZkClient zkClient;
    private String path;

    public DistributeEventEmmiter(ZkClient zkClient, String path) {
        this.zkClient = zkClient;
        try {
            this.zkClient.createEphemeral(path);
        }catch (Exception e){
            // exist ignore
        }
        this.path = path;
    }


    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(Object o) {
        if (o instanceof DistributedEvent) {
            DistributedEvent event = (DistributedEvent) o;
            if (event.isDistributed()) {
                zkClient.writeData(this.path, event.getSource());
            }
        }
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
