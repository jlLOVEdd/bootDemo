package com.wdd.bootDemo.dao;

import com.wdd.bootDemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

    User getUser();

}
