package com.doctor.main.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EmptyData.class)
	public ResponseEntity<Object> Excep1(EmptyData ex, WebRequest request){
		ExceptionModel excp = new ExceptionModel(ex.getMsg(),request.getDescription(false));
		return new ResponseEntity<Object>(excp ,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(WrongId.class)
	public ResponseEntity<Object> Excep2(WrongId ex, WebRequest request){
		ExceptionModel excp = new ExceptionModel(ex.getMsg(),request.getDescription(false));
		return new ResponseEntity<Object>(excp ,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> Excep3(Exception ex, WebRequest request){
		ExceptionModel excp = new ExceptionModel(ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(excp ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
