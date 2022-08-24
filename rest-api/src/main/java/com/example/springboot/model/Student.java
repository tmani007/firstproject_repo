package com.example.springboot.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	
	@Column(name="created_at")
	@CreationTimestamp
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	@CreationTimestamp
	private Timestamp updatedAt;

	public Student(String name, String email) {
		//super();
		this.name = name;
		this.email = email;
	}

}
