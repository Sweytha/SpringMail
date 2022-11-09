package com.mail.controller;



import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.service.SpringMailService;



@RestController
public class SpringMailController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SpringMailService mailService;

	@GetMapping(value = "/sendemail")
	public String sendEmail() throws AddressException, MessagingException {
		
	    logger.debug("Sending Email");

	    this.mailService.sendEmail();
	
	    return "Email sent successfully";
	}

}