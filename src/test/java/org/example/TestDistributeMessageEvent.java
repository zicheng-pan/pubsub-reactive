package org.example;

import org.I0Itec.zkclient.ZkClient;
import org.example.distribute.DistributeEventSubstriber;
import org.example.distribute.DistributedEvent;
import org.example.distribute.DistrubuteEventPubliser;
import org.junit.Test;

public class TestDistributeMessageEvent {

    @Test
    public void testPubSub() throws InterruptedException {
        ZkClient zkClient = new ZkClient("localhost:2181");
        String serviceName = "/tempNode01";
        DistrubuteEventPubliser publiser = new DistrubuteEventPubliser(zkClient, serviceName);
//        publiser.subscribe(new DistributeEventSubstriber(zkClient, serviceName));
        new DistributeEventSubstriber(zkClient, serviceName);
        publiser.publish(new DistributedEvent("data11111"));
        // set timeout till notifier got message event
        Thread.sleep(1000);
        publiser.publish(new DistributedEvent("data22222"));
        Thread.sleep(1000);
        publiser.publish(new DistributedEvent("data33333"));
        Thread.sleep(1000);


        // block thread here to wait notify event
        for (; ; ) ;
    }
}
