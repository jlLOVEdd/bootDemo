package com.wdd.bootDemo.common.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PeopleProxy implements InvocationHandler {

        private  People target;

    public PeopleProxy(People target) {
        this.target = target;
    }

    public Object getProxy() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理在方法之前增强!");
        Object result =method.invoke(target,args);
        System.out.println("代理在方法后增加");
        return result;
    }
}
