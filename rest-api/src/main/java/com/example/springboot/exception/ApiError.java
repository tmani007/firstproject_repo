package com.example.springboot.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
	
	private String message;
	private HttpStatus status;
	private LocalDateTime timestamp;

}
