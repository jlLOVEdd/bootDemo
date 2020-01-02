package com.wdd.bootDemo.aspect;

import com.wdd.bootDemo.annotation.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Description 操作日志的拦截切面
 * @Author weidongdong
 * @Date 2019/11/14 16:09
 * @Version 1.0
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.wdd.bootDemo.annotation.OperateLog)")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void before() {
        log.debug("method---------------before");
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("around----before");
        Object result = null;
        /*****************放行方法***************/
        try {

            result = joinPoint.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }

        /****************获取信息记录操作日志信息*****************/
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        OperateLog logAnnotation = method.getAnnotation(OperateLog.class);
        log.debug(logAnnotation.type().getOperateName());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.debug("around----after");

        return result;
    }


    @AfterReturning("pointCut()")
    public void afterReturn() {
        log.debug("method---------------afterReturn");
    }

    @After("pointCut()")
    public void after() {
        log.debug("method---------------after");
    }

    @AfterThrowing("pointCut()")
    public void Throwing() {
        log.debug("method---------------Throwing");
    }
}
