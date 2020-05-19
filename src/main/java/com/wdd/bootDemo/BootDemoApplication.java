package com.wdd.bootDemo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.wdd.bootDemo.dao",annotationClass = Repository.class)
@EnableTransactionManagement
public class BootDemoApplication {

	public static void main(String[] args) {


		SpringApplication.run(BootDemoApplication.class, args);
	}

}
