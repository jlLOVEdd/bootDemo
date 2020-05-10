package com.wdd.bootDemo.action;

import com.wdd.bootDemo.annotation.OperateLog;
import com.wdd.bootDemo.annotation.OperateType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Value("${spr}")
    private String spr;


    @GetMapping("/tt")
    @OperateLog(type = OperateType.ADD)
    public String tes1t() {
        throw new RuntimeException();
//        return "test!!!!";
    }

    @GetMapping("/spr")
    public String Spr() {
        return spr;
    }

    @GetMapping("/index")
    @OperateLog(type = OperateType.DELETE)
    public String test() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("------------exception");
        } finally {
            System.out.println("---------finally");
        }
        System.out.println("return ---------------");
        return testValue;
    }

    @GetMapping("/fr")
    @OperateLog(type = OperateType.DELETE)
    public int finallyReturn() {
        try {
            int i = 8 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("------------exception");
            return 2;
        } finally {
            System.out.println("---------finally");
            return 0;
        }

    }

}
