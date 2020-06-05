package com.wdd.bootDemo.test;

import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/**
 * @Description 正则表达式测试
 * @Author weidongdong
 * @Date 2019/12/13 17:15
 * @Version 1.0
 */
public class RegularTest {
   /* public static void main(String[] args) {
        String test = "\\a";
        String pattern = "\\\\a*";
        System.out.println( Pattern.matches(pattern, test));
    }*/
   static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        lock.lock();
       Thread thread1 = new Thread(()->{
           lock.lock();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        });
        thread1.setName("Thread1");

        thread1.start();


    }
}
