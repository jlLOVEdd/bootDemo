package com.wdd.bootDemo.service;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @Description OrderService
 * @Author weidongdong
 * @Date 2020/5/8 15:49
 * @Version 1.0
 */
@Service
@Data
public class OrderService {
    private String productName;
    private String ProductNo;
}
