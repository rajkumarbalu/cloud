package com.service.helloservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello/")
public class HelloController {
	@GetMapping("/{username}")
	public String sayHello(@PathVariable("username") final String username) {
		return "Hi " + username + ", Welcome to spring cloud and microservice";
	}
}
