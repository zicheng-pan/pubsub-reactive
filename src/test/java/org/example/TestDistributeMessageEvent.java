package org.example;

import org.I0Itec.zkclient.ZkClient;
import org.example.distribute.DistributeEventSubstriber;
import org.example.distribute.DistributedEvent;
import org.example.distribute.DistrubuteEventPubliser;
import org.junit.Test;

public class TestDistributeMessageEvent {

    @Test
    public void testPubSub() {
        ZkClient zkClient = new ZkClient("localhost:2181");
        String path = "/tempNode01";
        DistrubuteEventPubliser publiser = new DistrubuteEventPubliser(zkClient, path);
        publiser.subscribe(new DistributeEventSubstriber(zkClient, path));
        publiser.publish(new DistributedEvent("data11111"));
    }
}
