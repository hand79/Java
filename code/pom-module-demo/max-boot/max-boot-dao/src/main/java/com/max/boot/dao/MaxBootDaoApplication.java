package com.max.boot.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.max.boot.dao.*")
@SpringBootApplication
public class MaxBootDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxBootDaoApplication.class, args);
	}
}
