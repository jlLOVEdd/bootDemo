package com.wdd.bootDemo.config.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.proto.GetDataResponse;
import org.apache.zookeeper.proto.ReplyHeader;
import org.apache.zookeeper.server.watch.WatcherMode;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Description ZookeeperClient
 * @Author weidongdong
 * @Date 2020/5/22 14:02
 * @Version 1.0
 */
public class ZookeeperClient implements Watcher {
    private final static int SESSION_TIMEOUT = 5000;
    private ZooKeeper zooKeeper = null;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }
    }

    public void getConnection(String host) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(host, SESSION_TIMEOUT, this);
        countDownLatch.await();
    }

    public void createNode(String nodeName,String data) throws KeeperException, InterruptedException {
        String path = "/" + nodeName;
        zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path + "  created");
    }


    public String getNodeData(String nodeName,Watcher watcher) throws KeeperException, InterruptedException {
        String path = "/" + nodeName;
        byte[] bytes = zooKeeper.getData(path,watcher,null);
        return new String(bytes);
    }

    public void addWatcher(String nodeName,Watcher watcher) throws KeeperException, InterruptedException {
        String path = "/" + nodeName;
        zooKeeper.addWatch(path,watcher, AddWatchMode.PERSISTENT);
    }


    public void close() {
        if (zooKeeper != null) {

            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                zooKeeper = null;
            }

        }

    }
}
