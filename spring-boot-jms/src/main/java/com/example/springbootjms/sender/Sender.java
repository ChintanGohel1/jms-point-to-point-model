package com.example.springbootjms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class Sender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String message) {
//		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.convertAndSend("HelloWorld", message);
	}

}
