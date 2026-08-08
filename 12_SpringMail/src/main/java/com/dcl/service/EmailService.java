package com.dcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateparser.markup.HTMLTemplateParser;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender jms;
	
	@Autowired
	private TemplateEngine engine;

	public Boolean sendMail(String receiver) {
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setTo(receiver);
		message.setSubject("Welcome To Spring Boot");
		message.setText("This is a test message for verification");
		message.setCc("syedsulaimanahmed.29@gmail.com");
		String[] bcc= {"sahsushant1998@gmail.com","roshanyadav2029@gmail.com"};
		message.setBcc(bcc);
		jms.send(message);
		return true;
	}
	
	
	public Boolean sendHtmlMail(String receiver) {
		
		MimeMessage message=jms.createMimeMessage(); //abstract class
		Context c=new Context();
		c.setVariable("name", "Suhas");
		
		
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message, true);
			//message.setContent(c, "demo");
			helper.setTo(receiver);
			helper.setSubject("Demo Message");
			helper.setText(engine.process("demo", c),true);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jms.send(message);
		return true;
	}
}
