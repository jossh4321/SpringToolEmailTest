package com.springboot.app.mail.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

import com.springboot.app.mail.config.service.MailSenderService;
import com.springboot.app.mail.config.service.NotificationService;

@Configuration
public class MailConfig {
	
	@Autowired
	private MailSenderService mailsender;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		return mailsender.getJavaMailSender("", "");
	}
}
