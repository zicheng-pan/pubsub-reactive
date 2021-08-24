package org.example.provider;

import org.example.Subscriber;
import org.example.Subscription;

public class DecoratingSubscriber<T> implements Subscriber<T> {

    private org.reactivestreams.Subscriber businessSubscriber;
    private Boolean isCancle = false;

    public DecoratingSubscriber(org.reactivestreams.Subscriber businessSubscriber) {
        this.businessSubscriber = businessSubscriber;
    }


    @Override
    public void onSubscribe(org.reactivestreams.Subscription s) {
        businessSubscriber.onSubscribe(s);
    }

    @Override
    public void onNext(Object o) {
        if (isCancle) {
            System.out.println(" this is innerOperation the operation is cancle");
        }

        businessSubscriber.onNext(o);
    }

    @Override
    public void onError(Throwable var1) {

    }

    @Override
    public void onComplete() {

    }

    public void cancle() {
        this.isCancle = true;
    }
}
