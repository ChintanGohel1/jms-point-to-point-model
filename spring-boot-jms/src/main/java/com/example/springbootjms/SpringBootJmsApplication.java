package com.example.springbootjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = { "com.example.springbootjms.receiver", "com.example.springbootjms.sender",
		"com.example.springbootjms.controller" })
public class SpringBootJmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootJmsApplication.class, args);

	}

}
