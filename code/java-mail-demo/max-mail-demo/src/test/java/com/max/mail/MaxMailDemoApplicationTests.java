package com.max.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;
	
@RunWith(SpringRunner.class)
@SpringBootApplication
public class MaxMailDemoApplicationTests {
	@Autowired
	MailConfigProperties mailConfig;
	
	@Test
	public void contextLoads() {
	}

	
	
	@Test
	public void testProperties(){
		System.out.println(mailConfig.toString());
	}
}
