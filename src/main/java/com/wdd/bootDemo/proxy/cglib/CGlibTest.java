package com.wdd.bootDemo.proxy.cglib;

import com.wdd.bootDemo.proxy.SampleFactory;
import com.wdd.bootDemo.proxy.SimpleClass;
import net.sf.cglib.beans.BeanMap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description CGlibTest
 * @Author weidongdong
 * @Date 2020/5/21 10:04
 * @Version 1.0
 */
public class CGlibTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        CglibProxy<SimpleClass> proxy = new CglibProxy<>();
//       SimpleClass simpleClass = proxy.getProxy(SimpleClass.class);
        /*SimpleClass simpleClass = proxy.getFilterProxy(SimpleClass.class);
        System.out.println(simpleClass.music());
        System.out.println(simpleClass.test());
        simpleClass.test1();*/
//
//        SimpleClass simpleClass1 = new SimpleClass();
//        simpleClass1.setTest("Bean");
//        SimpleClass imBean = proxy.immuTableBeanFroxy(simpleClass1);
//        simpleClass1.setTest("ImmuTableBean");
//        System.out.println(imBean.getTest());
//        imBean.setTest("Exception");
//
//
      /*  Object generaterBean  = proxy.generaterBean();
        Method getValue = generaterBean.getClass().getMethod("getValue");
        System.out.println(getValue.invoke(generaterBean).toString());
*/
        /*SimpleClass simpleClass = new SimpleClass();
        SimpleClass simpleClass1 = new SimpleClass();
        simpleClass.setTest("one");
        System.out.println("copy before............"+simpleClass1.getTest());
        proxy.beanCopier(simpleClass,simpleClass1);
        System.out.println("copy after-------------"+simpleClass1.getTest());

        Object[] values = proxy.bulkBeanTest(simpleClass1);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].toString());
        }*/

       /* //获取一个姓名账号密码的map
        BeanMap map = proxy.getBeanMap();
        for (Object o : map.keySet()) {
            System.out.println(o.toString()+"--------------"+map.get(o.toString()));
        }*/

          /* //生成接口的实例类
            Object sampleFactory1 = proxy.getBeanByKeyfactory(SampleFactory.class,"sss",4);
            //生成接口
            proxy.interfaceMaker();*/
          SimpleClass simpleClass =new SimpleClass();
          simpleClass.setTest("sssss");
          proxy.methodDelegate(simpleClass);

    }
}
