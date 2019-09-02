package com.demo.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpa.dao.UserRepository;
import com.demo.jpa.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	@PostConstruct
	public void initDB() {
		List<User> users = new ArrayList<>();
		users.add(new User(111, "A", "IT", 23));
		users.add(new User(123, "B", "IT", 23));
		users.add(new User(133, "D", "IT1", 23));
		users.add(new User(143, "E", "IT", 23));
		users.add(new User(153, "F", "IT1", 23));
		users.add(new User(163, "G", "IT", 23));
		repository.saveAll(users);
	}
	
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	public List<User> getByProfession(String profession) {
		return repository.findByProfession(profession);
	}
	
	public long countByAge(int age) {
		return repository.countByAge(age);
	}
}
