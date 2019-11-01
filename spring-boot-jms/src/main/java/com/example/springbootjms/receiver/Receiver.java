package com.example.springbootjms.receiver;

import org.springframework.jms.annotation.JmsListener;

public class Receiver {

	@JmsListener(destination = "Ack")
	public void receive(String message) {
		System.out.println("Hii this is a received message" + message);
	}
}
