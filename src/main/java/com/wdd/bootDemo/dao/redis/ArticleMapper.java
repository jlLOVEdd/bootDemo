package com.wdd.bootDemo.dao.redis;

import com.wdd.bootDemo.entity.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description ArticleMapper
 * @Author weidongdong
 * @Date 2020/5/25 11:32
 * @Version 1.0
 */
public interface ArticleMapper extends CrudRepository<Article,Integer> {
}
