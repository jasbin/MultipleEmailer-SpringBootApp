package com.emailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.emailer.domain.User;

@Service
public class MailService {
	private JavaMailSender javaMailSender;
	
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void SendEmail(User user) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("freakysoulz@gmail.com");
		mail.setSubject("Acceptance Notice");
		mail.setText("dear, "+ user.getName() +" you have been selected for the "+ user.getCourse()+" thankyou!");
		javaMailSender.send(mail);
	}
}
