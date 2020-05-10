package com.wdd.bootDemo.test;

import com.wdd.bootDemo.common.utils.Bob;
import com.wdd.bootDemo.common.utils.People;
import com.wdd.bootDemo.common.utils.PeopleProxy;
import com.wdd.bootDemo.common.utils.PeopleProxyFactory;

public class ProxyTest {
    public static void main(String[] args) {
        People bob = new Bob();
        bob.saySomething();


        System.out.println("-------------------");
        PeopleProxy peopleProxy =   new PeopleProxy(bob);
//        PeopleProxyFactory  peopleProxyFactory = new PeopleProxyFactory(bob);
        People proxy = (People)peopleProxy.getProxy();

        proxy.saySomething();

    }
}
