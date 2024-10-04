package com.bookapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		headers.add("info", "Method not allowed");
		String message = "This 	Http method is not allowed";
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), status.value(),ex.getMessage(), message);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		headers.add("info", "Media type not supported");
		String message = "Invalid media type";
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), status.value(),ex.getMessage(), message);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		headers.add("info", ex.getMessage());
		String message = "Path Variable is missing";
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), status.value(),ex.getMessage(), message);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		headers.add("info", ex.getMessage());
		String message = "Missing Servlet Request Parameter"+ex.getParameterName();
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), status.value(),ex.getMessage(), message);
//		return ResponseEntity.status(status).headers(headers).body(apiErrors);
		return handleExceptionInternal(ex, apiErrors, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		headers.add("info", "TypeMismatch");
		String message = "Invalid type";
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), status.value(),ex.getMessage(), message);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFound(BookNotFoundException ex){
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "TypeMismatch");
		String message = "Invalid type";
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),ex.getMessage(), message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
		
	}
	
}
