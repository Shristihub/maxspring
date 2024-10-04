package com.bookapp.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrors {

	LocalDateTime timestamp;
	int status;
	String error;
	String message;
}
