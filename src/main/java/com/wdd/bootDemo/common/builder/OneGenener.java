package com.wdd.bootDemo.common.builder;

/**
 * @Description OneGenener
 * @Author weidongdong
 * @Date 2020/5/11 14:52
 * @Version 1.0
 */
public class OneGenener<T> implements GenerInfo<T> {

    @Override
    public T getTarget() {
        return null;
    }

    @Override
    public T getMsg(Class<T> clazz) {
        return null;
    }
}
