package com.max.mail.async;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
		log.info("Exception message - " + throwable.getMessage());
		log.info("Method name - " + method.getName());
		for (Object param : obj) {
			log.info("Parameter value - " + param);
		}
	}


}