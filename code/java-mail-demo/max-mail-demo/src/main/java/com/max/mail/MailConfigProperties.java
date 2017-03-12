package com.max.mail;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*  Demo how to config properties */
@Component
@PropertySource("classpath:application.properties")
public class MailConfigProperties {

    @Value("${spring.mail.host}")
    private String host;
    
    @Value("${spring.mail.username}")
    private String username;
    
    @Value("${spring.mail.password}")
    private String password;
    
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private Boolean auth;
   
    @Value("${spring.mail.properties.mail.smtp.socketFactory.port}")
    private Integer port;
    
    @Value("${spring.mail.properties.mail.smtp.socketFactory.fallback}")
    private Boolean fallback;
    
    @Value("${spring.mail.properties.mail.smtp.ssl.enable}")
    private Boolean enable;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return new String(Base64.decodeBase64(this.username.getBytes()));
	}
	// set data by encode
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return new String(Base64.decodeBase64(this.password.getBytes()));
	}
	// set data by encode
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAuth() {
		return auth;
	}

	public void setAuth(Boolean auth) {
		this.auth = auth;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Boolean getFallback() {
		return fallback;
	}

	public void setFallback(Boolean fallback) {
		this.fallback = fallback;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "MailConfig [host=" + host + ", username=" + username + ", password=" + password + ", auth=" + auth
				+ ", port=" + port + ", fallback=" + fallback + ", enable=" + enable + "]";
	}
    

}
