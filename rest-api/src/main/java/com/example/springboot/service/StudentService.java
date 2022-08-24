package com.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.StudentNotFound;
import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;

import lombok.NonNull;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> fetchAllStudent() {
		return studentRepository.findAll();
	}
	
	public Student fetchStudent(int id) {
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFound("student not found with id "+id));
	}
	
	public Student updateStudent(@NonNull Student student) {
		
		Student selectedStudent = fetchStudent(student.getId());
		
		if(selectedStudent!= null && selectedStudent.getName()!=null && selectedStudent.getEmail()!=null ) {
			selectedStudent.setName(student.getName());
			selectedStudent.setEmail(student.getEmail());
			studentRepository.save(selectedStudent);
		}
		return student;
		
	}
		
		public String deleteStudent(@NonNull int id) {
						
				studentRepository.deleteById(id);
			
			return "Student Deleted";
		
      }

}
