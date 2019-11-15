package com.wdd.bootDemo.test;

/**
 * @Description TestMain
 * @Author weidongdong
 * @Date 2019/11/15 10:40
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println(fun());
    }

    public static StringBuffer fun() {
        int i=0;
        StringBuffer s =new StringBuffer("world");

        try {
            System.out.println("-------------try");
            return s;
        } catch (Exception e) {
            System.out.println("------------exception");
            return null;
        } finally {
            System.out.println("---------finally");
            i+=1;
            s.append("finally");

        }

    }
}
