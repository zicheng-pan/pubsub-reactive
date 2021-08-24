package org.example;

public interface Publisher<T> extends org.reactivestreams.Publisher {
    void subscribe(Subscriber<? super T> var1);
}
