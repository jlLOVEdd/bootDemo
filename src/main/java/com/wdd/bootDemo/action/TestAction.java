package com.wdd.bootDemo.action;

import com.wdd.bootDemo.annotation.OperateLog;
import com.wdd.bootDemo.annotation.OperateType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description testAction
 * @Author weidongdong
 * @Date 2019/11/7 15:06
 * @Version 1.0
 */
@RestController
public class TestAction {

    @Value("${test.value}")
    private String testValue;

    @GetMapping("/tt")
    @OperateLog(type = OperateType.ADD)
    public String tes1t() {
        throw  new RuntimeException();
//        return "test!!!!";
    }

    @GetMapping("/index")
    @OperateLog(type = OperateType.DELETE)
    public String test() {
        try{
            throw new RuntimeException();
        }catch (Exception e){
            System.out.println("------------exception");
        }finally {
            System.out.println("---------finally");
        }
        System.out.println("return ---------------");
        return testValue;
    }

}
