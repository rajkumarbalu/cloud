package com.security.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.Student;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
	
	private final static List<Student> students = Arrays.asList(
			new Student(1, "Rajkumar"),
			new Student(2, "Sanjana"),
			new Student(3, "Deva"),
			new Student(4, "Sathya")
			);
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		return ResponseEntity.ok().body(this.students.stream().filter(student -> student.getId() == id));
	}

}
