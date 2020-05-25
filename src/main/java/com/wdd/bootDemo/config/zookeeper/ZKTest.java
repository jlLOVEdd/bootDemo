package com.wdd.bootDemo.config.zookeeper;

import com.wdd.bootDemo.config.zookeeper.watcher.NodeDataWatcher;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @Description ZKTest
 * @Author weidongdong
 * @Date 2020/5/22 14:20
 * @Version 1.0
 */
public class ZKTest {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZookeeperClient zookeeperClient = new ZookeeperClient();

        zookeeperClient.getConnection("127.0.0.1:2181");
        zookeeperClient.createNode("eeee", "hello zookeeper");

        // System.out.println(zookeeperClient.getNodeData("java",new NodeDataWatcher()));
        zookeeperClient.addWatcher("java",new NodeDataWatcher());

       // Thread.sleep(110000);
        //zookeeperClient.close();
    }
}
