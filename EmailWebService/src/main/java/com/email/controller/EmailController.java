package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.email.Service.EmailService;
import com.email.model.EmailRequest;
import com.email.model.EmailResponse;

@RestController
@CrossOrigin
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/welcome")
	public String JustWelCome() {
		return "hello, this is my first email api";
	}
	
	
	// api to send Email
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		
		boolean sendEmail = emailService.sendEmail( request.getMessagetext(), request.getSubject(),request.getTo());
		System.out.println(request);
		if(sendEmail) {
			return ResponseEntity.ok(new EmailResponse("Email Send TO "+request.getTo()));	
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email Not Send"));
		}
		
		
	}
}
