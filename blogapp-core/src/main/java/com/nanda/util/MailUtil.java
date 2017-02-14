package com.nanda.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class MailUtil {

	


	public static void sendSimpleMail(String comments,String mailId,String password) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator(mailId, password));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom(mailId);// Admin email
		email.setSubject(" commented on your article");
		email.setMsg(comments);
		email.addTo(mailId);
		email.setStartTLSEnabled(true);
		email.send();

	}
	
}
