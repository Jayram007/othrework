package com.farmsystem.backend.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;



public class EmailServiceImpl {
	
	public static void sendMail(String mailTo) {
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("shubham13.sk@gmail.com", "fzxviauwxyfccphh");
			}
			
		});
		
		session.setDebug(true);
		
		Message message= new MimeMessage(session);
		try {
	     
			message.setFrom(new InternetAddress("shubham13.sk@gmail.com"));
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
	        message.setSubject("Your account has been created ");
	       // message.setText("welcome to kisan seva portal");
	       // message.setContent("welcome to kisan seva portal", "text/html; charset=utf-8");
	        message.setContent(
	                "<h1>welcome to kisan seva portal</h1>",
	               "text/html");


	        Transport.send(message);
	        System.out.println("success");
	    } catch (AddressException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
		
		
		
	}

}
