package com.wdd.bootDemo.test;

import java.util.concurrent.*;

public class TheadPool {
    public static void main(String[] args) {
        ExecutorService threadFactory = Executors.newCachedThreadPool();


        ExecutorService linkedList = Executors.newSingleThreadExecutor();

        ExecutorService myPools = new ThreadPoolExecutor(5, 20, 6000, TimeUnit.SECONDS, new ArrayBlockingQueue(1024), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setName("mytest-pool");
            return t;
        });
    }
}
