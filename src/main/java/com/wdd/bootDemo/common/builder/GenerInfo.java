package com.wdd.bootDemo.common.builder;

/**
 * @Description GenerInfo
 * @Author weidongdong
 * @Date 2020/5/11 14:49
 * @Version 1.0
 */
public interface GenerInfo<T> {

    /**
     * 测试泛型
     * @return
     */
    public  T getTarget();

    /**
     *
     * @param clazz
     * @return
     */
    public T getMsg(Class<T> clazz);
}
