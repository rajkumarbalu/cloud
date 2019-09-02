package com.demo.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpa.model.User;
import com.demo.jpa.service.UserService;

@RestController
@RequestMapping("/jpa-demo")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public List<User> getAll() {
		return service.getUsers();
	}
	
	@GetMapping("/profession/{profession}")
	public List<User> getAll(@PathVariable String profession) {
		return service.getByProfession(profession);
	}
	
	@GetMapping("/getUserCount/{age}")
	public String getCountByAge(@PathVariable int age) {
		return "Total no of records : " + service.countByAge(age);
	}

}
