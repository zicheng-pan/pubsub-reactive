package org.example.distribute;

import java.util.EventObject;

public class DistributedEvent extends EventObject {

    public DistributedEvent(Object source) {
        super(source);
    }

    public boolean isDistributed() {
        return true;
    }

}
