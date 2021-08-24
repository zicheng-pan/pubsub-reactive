package org.example.subscriber;

import org.example.Subscriber;
import org.reactivestreams.Subscription;

public class BusinessSubscriber<T> implements Subscriber<T> {

    // 表示已经接受的数量
    private int count = 0;
    private Subscription subscription;


    @Override
    public void onSubscribe(org.reactivestreams.Subscription s) {
        this.subscription = s;
    }

    @Override
    public void onNext(Object o) {
        // 接受了两条，已经到了最大处理能力
        if (count++ > 2) {
            subscription.cancel();
            return;
        }
        // 业务逻辑处理
        System.out.println(o);
    }

    @Override
    public void onError(Throwable var1) {

    }

    @Override
    public void onComplete() {
        System.out.println("complete ");
    }
}
