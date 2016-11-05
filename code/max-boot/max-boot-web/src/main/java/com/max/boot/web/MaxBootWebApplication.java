package com.max.boot.web;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.max.boot.*")//, excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Controller.class) )
@SpringBootApplication
public class MaxBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxBootWebApplication.class, args);
	}
}
