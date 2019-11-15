package com.wdd.bootDemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description OprateLog
 * @Author weidongdong
 * @Date 2019/11/14 15:51
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateLog {
    /**
     * 日志的操作类型
     * @return
     */
    OperateType type() default OperateType.DEFAULT;

    /**
     *
     * @return
     */
    String value() default "";
}
