package com.max.mail;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class PasswordEncoderTest {
	
	@Autowired
	MailConfigProperties mailConfig;
	
	@Autowired
	JavaMailSenderImpl mailSender; 
	
	@Test
	public void testBase64() throws UnsupportedEncodingException {
		// Base64 encode
		String encodeString = new String(Base64.encodeBase64("TT".getBytes()));
		// Base64 output
		System.out.println(encodeString);
		// Base64 decode
		String decodeString = new String(Base64.decodeBase64(encodeString.getBytes()));
		System.out.println(decodeString);
	}
	
	@Test
	public void testProperties(){
		System.out.println(mailConfig.toString());
	}
}
