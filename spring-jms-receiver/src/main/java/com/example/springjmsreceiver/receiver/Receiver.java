package com.example.springjmsreceiver.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.springjmsreceiver.domain.Message;
import com.example.springjmsreceiver.repository.MessageRepository;

@Component
public class Receiver {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private JmsTemplate jmsTemplate;

	@JmsListener(destination = "HelloWorld")
	public void receive(String message) {

		Message recievedMessage = new Message();
		recievedMessage.setMessage(message);
		Message msg = messageRepository.save(recievedMessage);
		if (msg != null) {
			jmsTemplate.convertAndSend("Ack",
					"Message is successfully Received & msg is : [" + msg.getMessage() + "]");
		}
		System.out.println("Hii this is a received message" + message);
	}
}
