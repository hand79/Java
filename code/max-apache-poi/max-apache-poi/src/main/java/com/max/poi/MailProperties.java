package com.max.poi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailProperties {

	@Value("${mail.smtp.user}")
	private String user;

	@Value("${mail.smtp.password}")
	private String password;

	@Value("${mail.smtp.host}")
	private String host;

	@Value("${mail.smtp.port}")
	private String port;

	@Value("${mail.smtp.auth}")
	private String auth;

	@Value("${mail.smtp.starttls.enable}")
	private String starttlsEnable;

	@Value("${mail.smtp.timeout}")
	private String timeout;

	@Value("${max.mail.to}")
	private String to;

	@Value("${max.mail.from}")
	private String from;

	@Value("${max.mail.cc}")
	private String cc;

	@Value("${max.mail.subject}")
	private String subject;

	@Value("${max.mail.content}")
	private String content;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getStarttlsEnable() {
		return starttlsEnable;
	}

	public void setStarttlsEnable(String starttlsEnable) {
		this.starttlsEnable = starttlsEnable;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MailProperties [user=" + user + ", password=" + password + ", host=" + host + ", port=" + port
				+ ", auth=" + auth + ", starttlsEnable=" + starttlsEnable + ", timeout=" + timeout + ", to=" + to
				+ ", from=" + from + ", cc=" + cc + ", subject=" + subject + ", content=" + content + "]";
	}

}
