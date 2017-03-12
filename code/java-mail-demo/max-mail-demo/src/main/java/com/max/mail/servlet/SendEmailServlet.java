package com.max.mail.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.max.mail.async.task.MailAsynkTask;
import com.max.mail.service.MailAsyncService;
import com.max.mail.service.MailService;

@Controller
public class SendEmailServlet {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MailService mailService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private MailAsynkTask mailAsynkTask;
	
	/*
	 * demo single thread send mail (need to wait response)
	 */

	@RequestMapping("/")
	public void sendEmailDefalut(@RequestParam String to ,@RequestParam(required = false, defaultValue="It is default <h1 style='color:blue;'>Max's</h1> text") String text ,HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("()... defalut");
		StopWatch sw = new StopWatch();
		sw.start();
		String from = "max@test.gmail";
		String subject = "java e-mail test!!!";
		for (int i = 0; i < 5; i++) {
			// send
			mailService.send(from, to, subject, text, true);
		}
		sw.stop();
		log.info(res.getClass().getSimpleName() + " --> END " + sw.getTotalTimeSeconds());
		StringBuffer ss = new StringBuffer("responseCode:0, " + sw.getTotalTimeSeconds());
		this.writeResponse(res, ss.toString());
	}
	// Mutiple Thread
	@RequestMapping("/async")
	public void sendEmailAsync(@RequestParam String to ,@RequestParam(required = false, defaultValue="It is default <h1 style='color:blue;'>Max's</h1> text") String text ,HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("()... async");
		StopWatch sw = new StopWatch();
		sw.start();
		String from = "max@test.gmail";
		String subject = "java e-mail test!!!";
		for (int i = 0; i < 5; i++) {
			// send
			MailAsyncService mailAsyncService = applicationContext.getBean(MailAsyncService.class);
			mailAsyncService.setContent(from, to, subject, text, true);
			Thread t = new Thread(mailAsyncService);
			t.start();
		}
		
		sw.stop();
		log.info(res.getClass().getSimpleName() + " --> END " + sw.getTotalTimeSeconds());
		StringBuffer ss = new StringBuffer("responseCode:0, " + sw.getTotalTimeSeconds());
		this.writeResponse(res, ss.toString());
	}

	/*
	 use spring @async
	 */
	@RequestMapping("/async-spring")
	public void sendEmailAsyncByAnnotation(@RequestParam String to ,@RequestParam(required = false, defaultValue="It is default <h1 style='color:blue;'>Max's</h1> text") String text ,HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("()... async-spring");
		StopWatch sw = new StopWatch();
		sw.start();
		String from = "max@test.gmail";
		String subject = "java e-mail test!!!";
		for (int i = 0; i < 5; i++) {
			// send
			mailAsynkTask.send(from, to, subject, text, true);
		}
		sw.stop();
		log.info(res.getClass().getSimpleName() + " --> END " + sw.getTotalTimeSeconds());
		StringBuffer ss = new StringBuffer("responseCode:0, " + sw.getTotalTimeSeconds());
		this.writeResponse(res, ss.toString());
	}
	
	private void writeResponse(HttpServletResponse res, String ss) throws IOException {
		log.debug("()..." + ss);
		PrintWriter pw = res.getWriter();
		pw.write(ss);
		pw.flush();
		pw.close();
		// res.setContentType("application/json; charset=UTF-8");
		// res.setHeader("Cache-Control", "no-cache");
		res.setStatus(HttpServletResponse.SC_OK);
		res.flushBuffer();
	}

}
