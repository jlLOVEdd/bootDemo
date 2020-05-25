package com.wdd.bootDemo;

import com.wdd.bootDemo.entity.Article;
import com.wdd.bootDemo.service.redis.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class BootDemoApplicationTests {


	@Autowired
	private ArticleService articleService;

	@Test
	void test() {
		Article article = new Article();
		/*article.setId(1);
		article.setTags("2019,Java,学习路线图");
		article.setTitle("2019新版Java学习路线图");
		article.setContent("Java学习路线图具体内容具体内容具体内容具体内容具体内容具体内容具体内容");
		article.setAllowComment("1");
		article.setCreated(new Date());
		article.setCategories("默认分类");*/

		/*article.setId(2);
		article.setTags("2019,Python,学习路线图");
		article.setTitle("2019新版Python学习线路图");
		article.setContent("据悉，Python已经入驻小学生教材，未来不学Python不仅知识会脱节，可能与小朋友都没有了共同话题~~所以，从今天起不要再找借口，不要再说想学Python却没有资源，赶快行动起来，Python等你来探索");
		article.setAllowComment("1");
		article.setCreated(new Date());
		article.setCategories("默认分类");

		article.setId(3);
		article.setTags("jdk8,Lambda,表达式");
		article.setTitle("JDK 8——Lambda表达式介绍");
		article.setContent(" Lambda表达式是JDK 8中一个重要的新特性，它使用一个清晰简洁的表达式来表达一个接口，同时Lambda表达式也简化了对集合以及数组数据的遍历、过滤和提取等操作。下面，本篇文章就对Lambda表达式进行简要介绍，并进行演示说明");
		article.setAllowComment("1");
		article.setCreated(new Date());
		article.setCategories("Lambda分类");

		article.setId(4);
		article.setTags("2019,Python,学习路线图");
		article.setTitle("函数式接口");
		article.setContent("虽然Lambda表达式可以实现匿名内部类的功能，但在使用时却有一个局限，即接口中有且只有一个抽象方法时才能使用Lamdba表达式代替匿名内部类。这是因为Lamdba表达式是基于函数式接口实现的，所谓函数式接口是指有且仅有一个抽象方法的接口，Lambda表达式就是Java中函数式编程的体现，只有确保接口中有且仅有一个抽象方法，Lambda表达式才能顺利地推导出所实现的这个接口中的方法");
		article.setAllowComment("1");
		article.setCreated(new Date());
		article.setCategories("函数式接口分类");

		article.setId(5);
		article.setTags("容器,虚拟化,Docker");
		article.setTitle("虚拟化容器技术——Docker运行机制介绍");
		article.setContent("Docker是一个开源的应用容器引擎，它基于go语言开发，并遵从Apache2.0开源协议。使用Docker可以让开发者封装他们的应用以及依赖包到一个可移植的容器中，然后发布到任意的Linux机器上，也可以实现虚拟化。Docker容器完全使用沙箱机制，相互之间不会有任何接口，这保证了容器之间的安全性");
		article.setAllowComment("1");
		article.setCreated(new Date());
		article.setCategories("虚拟化容器分类");

		article.setId(6);
		article.setTags("redis,scan,基本用法");
		article.setTitle("SCAN 命令的基本用法");
		article.setContent("SCAN 命令是一个基于游标的迭代器（cursor based iterator）： SCAN 命令每次被调用之后， 都会向用户返回一个新的游标， 用户在下次迭代时需要使用这个新游标作为 SCAN 命令的游标参数， 以此来延续之前的迭代过程");
		article.setAllowComment("1");
		article.setCreated(new Date());
		article.setCategories("缓存分类");*/

		System.out.println("------------------");
		articleService.insertArticleIntoRedis(article);
	}

	@Test
	public void getRedis(){
		Article article =articleService.findById(1);
		System.out.println("sss"+article);
	}

}
