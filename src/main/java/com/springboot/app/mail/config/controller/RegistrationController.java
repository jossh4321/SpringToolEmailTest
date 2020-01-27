package com.springboot.app.mail.config.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.mail.config.model.User;
import com.springboot.app.mail.config.service.NotificationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/signup")
	public String signUp() {
		return "please sign up for our service";
	}
	
	@RequestMapping("/signup-success")
	public String signUpSuccess() {
		
		User user = new User();
		user.setFirstName("receptor");
		user.setLastname("receptor");
		user.setEmailAddress("josuecd12@outlook.com");
		
		try {
			notificationService.sendNotification(user);
		}catch(MailException e) {
			System.out.println(e);
		}
		
		 return "Thank for registering with us";
	}
	
	@PostMapping("/attaching-files/addresemail/{correo}/password/{contrasena}")
	public String signUpSuccess2(@PathVariable String correo,@PathVariable String  contrasena/*,
			@RequestBody MultipartFile pdf*/) throws MessagingException, IOException {
		
		User user = new User();
		user.setFirstName("receptor");
		user.setLastname("receptor");
		user.setEmailAddress("josuecd12@outlook.com");
		
//		try {
			notificationService.sendMailWithAtachment(user/*, pdf*/,correo,contrasena);
//		}catch(MailException e) 
//			System.out.println(e);
//		}
		
		 return "Thank for registering with us";
	}
}
