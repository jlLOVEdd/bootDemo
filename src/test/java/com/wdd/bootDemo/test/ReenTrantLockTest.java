package com.wdd.bootDemo.test;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description ReenTrantLockTest
 * @Author weidongdong
 * @Date 2020/5/7 16:32
 * @Version 1.0
 */
@Data
public class ReenTrantLockTest {

    private volatile AtomicInteger test = new AtomicInteger(0);

    private ReentrantLock lock  = new ReentrantLock();
    public void add(){
        System.out.println(test.getAndIncrement());
    }

}
