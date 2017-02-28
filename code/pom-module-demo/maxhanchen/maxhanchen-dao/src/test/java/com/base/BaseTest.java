package com.base;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext.xml" })
public class BaseTest {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@BeforeClass
	public static void setupProperties() {
		System.setProperty("LOCATION", "LOCAL");
		System.setProperty("PROFILE", "LOCAL");
	}
	
	@Test
	public void main() throws Exception {
		log.debug("()...");
	}

}
