package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Student;
import com.example.springboot.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<Student> create(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.createStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Student>> find() {
		return new ResponseEntity<List<Student>>(studentService.fetchAllStudent(),HttpStatus.OK);
	}
	
	@GetMapping("/findOne/{id}")
	public ResponseEntity<Student> findOne(@PathVariable int id) {
		return new ResponseEntity<Student>(studentService.fetchStudent(id),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Student> update(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return new ResponseEntity<String>(studentService.deleteStudent(id),HttpStatus.ACCEPTED);
	}
	
	

}
