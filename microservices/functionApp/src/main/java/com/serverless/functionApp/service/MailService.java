package com.serverless.functionApp.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
    private Environment env;
	
	public void sendMail(String data) throws Exception{
		MimeMessage mailMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
			helper.setFrom(env.getProperty("spring.mail.username"));
			helper.setTo(data.split(";")[0]);
			helper.setSubject("Booking Confirmation - Bookings.com");
			helper.setText(data.split(";")[1]);
			mailSender.send(mailMessage);
		}catch( MessagingException | MailException e) {
			e.printStackTrace();
		}
	}
}
