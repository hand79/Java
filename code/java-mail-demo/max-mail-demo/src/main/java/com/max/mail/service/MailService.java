package com.max.mail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.max.mail.MailConfigProperties;

@Service
public class MailService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MailConfigProperties mailConfigProperties;
	
	@Autowired
	private JavaMailSenderImpl sender;
	
	public void send(String from, String to, String subject, String text, Boolean htmlFlag){
		// decode username 
		String username = mailConfigProperties.getUsername();
		sender.setUsername(username);
		// decode password 
		String password = mailConfigProperties.getPassword();
		sender.setPassword(password);
		// send 
		try {
			if(Boolean.TRUE == htmlFlag){
				sender.send(getHtmlMailMessage(from, to, subject, text));
			} else {
				sender.send(getSimpleMailMessage(from, to, subject, text));
			}
		} catch (MailException e) {
			log.error("MailException catch: " + e.getMessage());
		} catch (MessagingException e) {
			log.error("MessagingException catch: " + e.getMessage());
		} catch (Exception e) {
			log.error("catch: " + e.getMessage());
		}
	}
	
	// simple text
	public SimpleMailMessage getSimpleMailMessage(String from, String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setFrom(from);
		message.setSubject(subject);
		message.setText(text);
		return message;
	}
	
	// html
	public MimeMessage getHtmlMailMessage(String from, String to, String subject, String text) throws MessagingException {
	    MimeMessage mailMessage = sender.createMimeMessage(); 
	    MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage); 
	    messageHelper.setFrom(from);
	    messageHelper.setTo(to);
	    // true open html format
	    messageHelper.setText(text, true);
		return mailMessage;
	}
}
