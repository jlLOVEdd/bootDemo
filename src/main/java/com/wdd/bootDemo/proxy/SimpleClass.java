package com.wdd.bootDemo.proxy;

/**
 * @Description SimpleClass
 * @Author weidongdong
 * @Date 2020/5/21 9:54
 * @Version 1.0
 */

public class SimpleClass {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int test() {
        return 111;
    }

    public void test1() {
        System.out.println("void");
    }


    public String music() {
       return "hi siri come one music";
    }
}
