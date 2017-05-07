package com.max.poi.smtp;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.max.poi.MailProperties;

public class SmtpClient {

	private Logger log = LogManager.getLogger(this.getClass());

	public boolean sendMail(String fileFullPath, String filename, final MailProperties mailProperties) throws MessagingException, FileNotFoundException, IOException {
		try {
			Session session = Session.getDefaultInstance(this.getMailProperties(mailProperties), new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(new String(Base64.decodeBase64(mailProperties.getUser().getBytes())), new String(Base64.decodeBase64(mailProperties.getPassword().getBytes())));
				}
			});
//			session.setDebug(true);
			
			// message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(this.getDecode(mailProperties.getFrom())));
			message.addRecipients(Message.RecipientType.TO, this.getMails(mailProperties.getTo()));
			message.setRecipients(Message.RecipientType.CC, this.getMails(mailProperties.getCc()));
			message.setSubject(mailProperties.getSubject().replace("{attachment}", filename), "utf-8");
			
			// content
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setText(mailProperties.getContent());
			
			// file 
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			if (fileFullPath != null) {
				MimeBodyPart mimeBodyPartFile = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(fileFullPath);
				mimeBodyPartFile.setDataHandler(new DataHandler(fds));
				mimeBodyPartFile.setFileName(MimeUtility.encodeText(fds.getName()));
				multipart.addBodyPart(mimeBodyPartFile);
			}
			message.setContent(multipart);
			message.setSentDate(new Date());
			Transport.send(message);
			return true;
		} catch (Exception e) {
			log.error("catch:" + e.getMessage());
			return false;
		}
	}

	public Properties getMailProperties(MailProperties mailProperties){
		Properties props = new Properties();
		props.setProperty("mail.smtp.user",this.getDecode(mailProperties.getUser()));
		props.setProperty("mail.smtp.host", mailProperties.getHost());
		props.setProperty("mail.smtp.auth", mailProperties.getAuth());
		props.setProperty("mail.smtp.port", mailProperties.getPort());
		props.setProperty("mail.smtp.timeout", mailProperties.getTimeout());
		props.setProperty("mail.smtp.starttls.enable", mailProperties.getStarttlsEnable());
		return props;
	}
	
	private InternetAddress[] getMails(String mailsText) throws AddressException {
		if(mailsText.length()<=0 || mailsText == null){
			return null;
		}
		String[] mails = mailsText.split(",");
		InternetAddress[] mailsArray = new InternetAddress[mails.length];
		for (int i = 0; i < mails.length; i++) {
			mailsArray[i] = new InternetAddress(this.getDecode(mails[i]));
		}
		return mailsArray;
	}
	
	public String getDecode(String str){
		return new String(Base64.decodeBase64(str.getBytes()));
	}
}
