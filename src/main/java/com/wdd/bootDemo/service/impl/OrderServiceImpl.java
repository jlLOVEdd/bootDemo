package com.wdd.bootDemo.service.impl;

import com.wdd.bootDemo.dao.OrderDao;
import com.wdd.bootDemo.entity.User;
import com.wdd.bootDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;


    @Override

    public User getUser() {

        return orderDao.getUser();

    }
}
