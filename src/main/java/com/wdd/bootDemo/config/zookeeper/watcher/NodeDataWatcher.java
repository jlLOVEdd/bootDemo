package com.wdd.bootDemo.config.zookeeper.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @Description NodeDataWatcher
 * @Author weidongdong
 * @Date 2020/5/22 14:54
 * @Version 1.0
 */
public class NodeDataWatcher implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        if(event.getType()== Event.EventType.NodeDataChanged){
            System.out.println("节点数据修改");
        }else if (event.getType()==Event.EventType.NodeDeleted){
            System.out.println("节点数据删除");
        }else if (event.getType()==Event.EventType.NodeCreated){
            System.out.println("节点创建");
        }else if (event.getType()==Event.EventType.NodeChildrenChanged){
            System.out.println("节点子节点发生变化");
        }else if (event.getType()==Event.EventType. None){
            System.out.println("无时间发生");
        }

    }
}
