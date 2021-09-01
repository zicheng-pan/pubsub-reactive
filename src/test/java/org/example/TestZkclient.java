package org.example;

import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

public class TestZkclient {

    @Test
    public void testZKconnection(){
        ZkClient zkClient = new ZkClient("localhost:2181");
        zkClient.createEphemeral("/temp01","data01");
        System.out.println(zkClient.exists("/temp01"));

        for (;;);
    }

}
