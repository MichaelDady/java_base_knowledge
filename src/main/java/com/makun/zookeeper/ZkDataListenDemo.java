package com.makun.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkDataListenDemo {
    public static void main(String[] args) throws Exception {
        String path = "/username";
        Watcher watcher = new MyWatcher();
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 50000, watcher);
        System.out.println(new String(zk.getData(path, watcher, new Stat())));


        Thread.sleep(1000000000);
    }
}

class MyWatcher implements Watcher {

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("The state of zk: " + watchedEvent.getState() +", the event type : "  + watchedEvent.getType());
    }
}
