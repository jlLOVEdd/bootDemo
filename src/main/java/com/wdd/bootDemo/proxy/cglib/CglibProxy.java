package com.wdd.bootDemo.proxy.cglib;

import com.wdd.bootDemo.proxy.MyMethodDelegate;
import com.wdd.bootDemo.proxy.SampleFactory;
import net.sf.cglib.beans.*;
import net.sf.cglib.core.KeyFactory;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.*;
import net.sf.cglib.reflect.MethodDelegate;
import org.objectweb.asm.Type;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description CglibProxy
 * @Author weidongdong
 * @Date 2020/5/21 9:50
 * @Version 1.0
 */
public class CglibProxy<T> {

    /**
     * 拦截所有方法的代理
     *
     * @return
     */
    public T getProxy(Class<T> t) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("拦截方法前。。。。。。。。。。。。");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("拦截方法后。。。。。。。。。。。。");
                return result;
            }
        });

        return (T) enhancer.create();
    }

    /**
     * 拦截所有方法的返回值
     *
     * @param t
     * @return
     */
    public T loadObjectProxy(Class<T> t) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "object method return value";
            }
        });

        return (T) enhancer.create();
    }

    /**
     * callBack 为 InvocationHandler
     *
     * @param t
     * @return
     */
    public T getInvokeProxy(Class<T> t) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return "invocationHandler value";
                } else {
                    return null;
                }
            }
        });
        return (T) enhancer.create();
    }

    /**
     * 对指定的方法执行指定的callback函数
     *
     * @param t
     * @return
     */
    public T getFilterProxy(Class<T> t) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t);
        CallbackHelper callbackHelper = new CallbackHelper(t, null) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "String";
                        }
                    };
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());


        return (T) enhancer.create();
    }

    /**
     * 生成不可变的包装类
     *
     * @param t
     * @return
     */
    public T immuTableBeanFroxy(T t) {
        return (T) ImmutableBean.create(t);

    }

    /**
     * 生成一个类这个类有一个属性  运行时生成一个类
     *
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object generaterBean() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator generator = new BeanGenerator();
        generator.addProperty("value", String.class);
        Object mybean = generator.create();
        Method setValue = mybean.getClass().getMethod("setValue", String.class);
        setValue.invoke(mybean, "generate bean");
        return mybean;
    }

    /**
     * 拷贝克隆
     *
     * @param s
     * @param t
     * @param <T>
     * @param <S>
     * @return
     */
    public <T, S> S beanCopier(S s, T t) {
        BeanCopier beanCopier = BeanCopier.create(s.getClass(), t.getClass(), false);
        beanCopier.copy(s, t, null);
        return s;
    }

    /**
     * 获取bean的相关属性值
     *
     * @param t
     * @return
     */
    public Object[] bulkBeanTest(T t) {
        BulkBean bulkBean = BulkBean.create(t.getClass(), new String[]{"getTest"}, new String[]{"setTest"}, new Class[]{String.class});
        return bulkBean.getPropertyValues(t);
    }

    /**
     * 实体转map
     *
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public BeanMap getBeanMap() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("username", String.class);
        beanGenerator.addProperty("password", String.class);
        Object mybean = beanGenerator.create();
        Method userNameMethod = mybean.getClass().getMethod("setUsername", String.class);
        Method passwordMEthod = mybean.getClass().getMethod("setPassword", String.class);
        userNameMethod.invoke(mybean, "admin");
        passwordMEthod.invoke(mybean, "123456");

        return BeanMap.create(mybean);

    }

    /**
     * 生成接口的实例 重写了hashcode和equals方法  同一个参数构造出来的菜蔬相等
     * @param t
     * @param name
     * @param age
     * @return
     */
    public Object getBeanByKeyfactory(Class<? extends SampleFactory> t, String name, int age) {
        SampleFactory ss = (SampleFactory) KeyFactory.create(t);
        Object o1 = ss.newInstance("SS", age);
        Object o2 = ss.newInstance("SS", age);
        System.out.println(o1.equals(o2));
        return o1;
    }

    /**
     * 去获取自动生成的一个接口
     */
    public void interfaceMaker(){
        Signature signature = new Signature("foo", Type.DOUBLE_TYPE,new Type[]{Type.INT_TYPE});
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        interfaceMaker.add(signature,new Type[]{});
        Class iface =  interfaceMaker.create();
        System.out.println(iface.getMethods().length);
    }

    public void methodDelegate(T t){
        MyMethodDelegate methodDelegate = (MyMethodDelegate) MethodDelegate.create(t,"getTest", MyMethodDelegate.class);
        System.out.println(methodDelegate.getValueDelegate());

    }


}
