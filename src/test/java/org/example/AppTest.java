package org.example;

import org.example.provider.DefaultPublisher;
import org.example.subscriber.BusinessSubscriber;
import org.junit.Test;
import reactor.core.publisher.Mono;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMono() {
        Mono.just("hello, Mono").subscribe(data -> {
            System.out.println("subscribe consumer" + data);
        });
    }

    @Test
    public void testPublisher() {
        DefaultPublisher publisher = new DefaultPublisher();
        Mono from = Mono.from(publisher);
        for (int i = 0; i < 5; i++) {
            //可以看出每次执行 一次publish方法之后，
            // subscribe中的是代理了自己的subscriber对象类为 reactor.core.publisher.MonoNext
            // Mono代理的subscriber会先执行subscription中的cancle方法，然后执行自己真正的subscriber对象中的onNext方法
            // 然后执行自己的subscriber中的complete方法所以一次publish之后这个订阅者相当于完成使命了，所以每次都需要重复的进行订阅

            /*

            public void onNext(T t) {
			if (done) {
				Operators.onNextDropped(t, actual.currentContext());
				return;
			}
			s.cancel();
			actual.onNext(t);
			onComplete();
		    }
             */


            from.subscribe(new BusinessSubscriber());
            publisher.publish(i);
        }

    }

}
