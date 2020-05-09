package com.wdd.bootDemo.service.impl;

import com.wdd.bootDemo.annotation.OperateLog;
import com.wdd.bootDemo.service.LogService;
import com.wdd.bootDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description LogServiceImpl
 * @Author weidongdong
 * @Date 2020/5/8 13:54
 * @Version 1.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private OrderService orderService;

    @OperateLog
    @Override
    public void testLog() {
        System.out.println("-----------testLog-------------");
    }
}
