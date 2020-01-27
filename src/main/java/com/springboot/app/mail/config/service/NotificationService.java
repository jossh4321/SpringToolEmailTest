package com.springboot.app.mail.config.service;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.mail.config.model.User;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotification(User user) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("josuec4321@gmail.com");
		mail.setSubject("Venta de Productos");
		mail.setText("Esta es una notificacion de email desde SPRING!!");
		
		
		javaMailSender.send(mail);
	}
	
	public void sendMailWithAtachment(User user/*, MultipartFile pdf,/**/,String correo,String contraseña) throws MessagingException, IOException{
		
			JavaMailSender dinamicMailSender = mailSenderService.getJavaMailSender("josue@cavaling.com", "cavalinG4+!");
		    MimeMessage msg = dinamicMailSender.createMimeMessage();
		    
	        // true = multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo(user.getEmailAddress());
	        helper.setSubject("Testing from Spring Boot");
	        helper.setText("<h1>Check attachment for image!</h1>", true);
			// hard coded a file path
	        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));
	        //FileSystemResource file = new FileSystemResource(new File("D:\\Christ decent into the hell2.jpg"));
	       // helper.addAttachment("my_photo.pdf", pdf);
	        dinamicMailSender.send(msg);

		
		

		/* MimeMessage msg = javaMailSender.createMimeMessage();

	        // true = multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo(user.getEmailAddress());
	        helper.setSubject("Testing from Spring Boot");
	        helper.setText("<h1>Check attachment for image!</h1>", true);
			// hard coded a file path
	        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));
	        //FileSystemResource file = new FileSystemResource(new File("D:\\Christ decent into the hell2.jpg"));
	        helper.addAttachment("my_photo.pdf", pdf);
	        javaMailSender.send(msg);*/
	}
	
}
