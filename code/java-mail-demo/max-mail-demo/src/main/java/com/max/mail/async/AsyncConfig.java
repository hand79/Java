package com.max.mail.async;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

// application level
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(50);
		executor.setMaxPoolSize(200);
		executor.setQueueCapacity(3000);
		executor.setThreadNamePrefix("Max-do-Executor-");
		executor.initialize();
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new CustomAsyncExceptionHandler();
	}
	/* method level 
	@Bean("threadPoolTaskExecutor")
	public Executor threadPoolTaskExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(50);
		executor.setMaxPoolSize(200);
		executor.setQueueCapacity(3000);
		return executor;
	}
	*/
	/* if use xml bean
	 	<bean id="threadPoolTaskExecutor" class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
	  	<property name="corePoolSize" value="50" /> 
	  	<property name="maxPoolSize"  value="200" /> 
	  	<property name="queueCapacity" value="3000" /> </bean>
	 */
}
