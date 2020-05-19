package com.wdd.bootDemo.service;

import com.wdd.bootDemo.dao.OrderDao;
import com.wdd.bootDemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description OrderService
 * @Author weidongdong
 * @Date 2020/5/8 15:49
 * @Version 1.0
 */

public interface OrderService {



    public User getUser();
}
