package com.mail.service;

import java.util.Date;
import java.util.Properties;

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

import org.springframework.stereotype.Service;

//STARTTLS is an email protocol command that tells an email server that an email client, including an email client 
//running in a web browser, wants to turn an existing insecure connection into a secure one.
@Service
public class SpringMailService {

	public void sendEmail() throws AddressException, MessagingException {

		   Properties props = new Properties();
		   
		   props.put("mail.smtp.auth", "true");  //enable authentication
		   props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		   props.put("mail.smtp.host", "smtp.gmail.com");// enable SMTP host
		   props.put("mail.smtp.port", "587"); //TLS port

           /*
		    * As this example uses Gmail, please ensure a new password is 
            * created properly with the Google two-step verification feature.
		    */    
        
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("sweytha@bptn.com", "<password>");
		      }
		   });
		   
		   Message msg = new MimeMessage(session);
		   
		   msg.setFrom(new InternetAddress("sweytha@bptn.com", false));

           /* Recipient */
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sweytha@bptn.com"));
		   msg.setSubject("I Love Spring Mail");
		   msg.setContent("Welcome to Spring Mail", "text/html");
		   msg.setSentDate(new Date());
	

		   Multipart multipart = new MimeMultipart(); //Create a MultiPart Message 

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("I love Spring", "text/html");
		   multipart.addBodyPart(messageBodyPart); // Add the body to the MultiPart
		   
		   
		   msg.setContent(multipart);
		   
		   Transport.send(msg);   
		}
}