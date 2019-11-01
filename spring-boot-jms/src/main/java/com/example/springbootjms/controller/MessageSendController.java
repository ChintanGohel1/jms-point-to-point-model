package com.example.springbootjms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjms.sender.Sender;

@RestController
public class MessageSendController {

	@Autowired
	private Sender sender;
	
	public static final String PATH_SEND_MESSAGE = "/sendMessage/{msg}";
	
	@PostMapping(path = PATH_SEND_MESSAGE)
	public void sendMessage(@PathVariable(name = "msg") String message){
			sender.send(message);
	}

}
