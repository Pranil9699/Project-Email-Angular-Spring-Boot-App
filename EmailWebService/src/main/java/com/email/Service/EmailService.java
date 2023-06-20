package com.email.Service;


import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Service
public class EmailService {

	// write the Service or method to send the email , boolean type method

	public boolean sendEmail(String messagetext, String subject, String to) {
		boolean isSent=false;
		String from="takawanepranil22@gmail.com";
		// SMTP properties
		Properties smtpProperties = new Properties();
		smtpProperties.put("mail.smtp.auth", true);
		smtpProperties.put("mail.smtp.starttls.enable", true);
		smtpProperties.put("mail.smtp.ssl.enable", true);
		smtpProperties.put("mail.smtp.port", 465);
		smtpProperties.put("mail.smtp.host", "smtp.gmail.com");

		final String username = "takawanepranil22@gmail.com";
		final String password = "qonifztsuzyswhsb";

		Session session = Session.getInstance(smtpProperties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setText(messagetext);
			

			Transport.send(message);
System.out.println("Email done");
			isSent = true;
		} catch (MessagingException e) {
			System.err.println("Error occurred while sending the email: " + e.getMessage());
		}

		return isSent;
	}

}
