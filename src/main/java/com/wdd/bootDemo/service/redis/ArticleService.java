package com.wdd.bootDemo.service.redis;

import com.wdd.bootDemo.dao.redis.ArticleMapper;
import com.wdd.bootDemo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description ArticleService
 * @Author weidongdong
 * @Date 2020/5/25 11:46
 * @Version 1.0
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public void insertArticleIntoRedis(Article article) {
        articleMapper.save(article);
    }

    public Article findById(Integer id) {
        return articleMapper.findById(id).get();
    }

    public List<Article> getArticleList() {
        return (List)articleMapper.findAll();
    }

}
