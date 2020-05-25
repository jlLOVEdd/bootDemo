package com.wdd.bootDemo.action.redis;

import com.wdd.bootDemo.service.redis.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description ArticleController
 * @Author weidongdong
 * @Date 2020/5/25 13:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/index")
    public String ArticleList(ModelMap modelMap){
        modelMap.addAttribute("articles",articleService.getArticleList());
        return "index";
    }
}
