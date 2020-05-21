package com.wdd.bootDemo.proxy;

/**
 * @Description SampleFactory
 * @Author weidongdong
 * @Date 2020/5/21 14:46
 * @Version 1.0
 */
public interface SampleFactory {
    Object newInstance(String name,int age);
}
