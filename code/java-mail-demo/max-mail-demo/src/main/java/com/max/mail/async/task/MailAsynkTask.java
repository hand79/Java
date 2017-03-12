package com.max.mail.async.task;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.max.mail.service.MailAsyncService;
import com.max.mail.service.MailService;

// use spring async
@Component
public class MailAsynkTask {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MailService mailService;
	
	@Async
	public Future<String> send(String from, String to, String subject, String text, Boolean htmlFlag){
		StopWatch sw = new StopWatch();
		sw.start();
		mailService.send(from, to, subject, text, htmlFlag);
		sw.stop();
		log.info(" --> END " + sw.getTotalTimeSeconds());
		return new AsyncResult<>("send email --> " + sw.getTotalTimeSeconds());
	}
	
	
}
