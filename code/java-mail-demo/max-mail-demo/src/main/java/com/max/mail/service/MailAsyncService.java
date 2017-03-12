package com.max.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Scope("prototype")
public class MailAsyncService implements Runnable {
	
	private String from;
	private String to;
	private String subject;
	private String text;
	private Boolean htmlFlag;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MailService mailService;
	
	@Override
	public void run() {
		log.info("Start run -->" + this.getClass().getSimpleName());
		StopWatch sw = new StopWatch();
		sw.start();
		mailService.send(this.from, this.to, this.subject, this.text, this.htmlFlag);
		sw.stop();
		log.info("END --> " + sw.getTotalTimeSeconds());
	}
	
	public void setContent(String from, String to, String subject, String text, Boolean htmlFlag){
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
		this.htmlFlag = htmlFlag;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getHtmlFlag() {
		return htmlFlag;
	}

	public void setHtmlFlag(Boolean htmlFlag) {
		this.htmlFlag = htmlFlag;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	
}
