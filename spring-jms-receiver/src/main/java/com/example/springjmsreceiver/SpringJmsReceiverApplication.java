package com.example.springjmsreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = { "com.example.springjmsreceiver.receiver", "com.example.springjmsreceiver.domain" })
public class SpringJmsReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsReceiverApplication.class, args);
	}

}
