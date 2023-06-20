package com.email.model;

public class EmailRequest {

	private String to,subject,messagetext;

	public EmailRequest(String to, String subject, String messagetext) {
		super();
		this.to = to;
		this.subject = subject;
		this.messagetext = messagetext;
	}

	public EmailRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessagetext() {
		return messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	@Override
	public String toString() {
		return "EmailRequest [to=" + to + ", subject=" + subject + ", messagetext=" + messagetext + "]";
	}
	
	
}
