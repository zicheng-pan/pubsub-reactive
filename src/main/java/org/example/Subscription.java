package org.example;

public interface Subscription extends org.reactivestreams.Subscription {
    // 通过此方法发出请求信号，媒体不会发出任何事件。
    void request(long var1);

    // 请求媒体停止发送数据，并清理资源。
    void cancel();
}
