package org.example.distribute;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.example.Subscriber;
import org.reactivestreams.Subscription;

import java.util.EventObject;

public class DistributeEventSubstriber implements Subscriber<EventObject> {

    private String path;

    public DistributeEventSubstriber(ZkClient zkClient, String path) {
        this.path = path;
        zkClient.subscribeDataChanges(path, new IZkDataListener() {

            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                onNext(o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        });
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(Object o) {
        System.out.println("distribute data recevied..." + o);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
