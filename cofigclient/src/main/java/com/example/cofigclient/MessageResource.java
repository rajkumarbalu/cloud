package com.example.cofigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api")
public class MessageResource {
	
	@Value("${message: Default Hello}")
	private String message;
	
	@GetMapping("/msg")
	public String message() {
		return message;
	}

}
