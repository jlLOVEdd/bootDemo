package com.wdd.bootDemo.action;

import com.wdd.bootDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/index1")
    public String index() {
        return "index";
    }

        @RequestMapping("/fragment")
    public String fragment() {
        return "fragment";
    }

    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/base")
    public String base() {

        return orderService.getUser().getUserName();
    }


}