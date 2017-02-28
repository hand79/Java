package com.max.xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.max.xml.*")
@SpringBootApplication
public class MaxXmlRpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxXmlRpcApplication.class, args);
	}
}
