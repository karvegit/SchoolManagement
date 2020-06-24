package com.school.management.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.school.management.bean.ResponseException;

@ControllerAdvice
@RestController
public class StudentManagementResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ResponseException responseException = new ResponseException( new Date(), ex.getMessage(), request.getDescription(false)) ;
		
		return new ResponseEntity( responseException, HttpStatus.INTERNAL_SERVER_ERROR );
 
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		ResponseException responseException = new ResponseException( new Date(), ex.getMessage(), request.getDescription(false)) ;
		
		return new ResponseEntity( responseException, HttpStatus.NOT_FOUND );

	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request ) {

		ResponseException responseException = new ResponseException( new Date(), ex.getMessage(), ex.getBindingResult().toString()) ;
		//ResponseException responseException = new ResponseException( new Date(), "Validation Falied!!", ex.getBindingResult().toString()) ;
		//ResponseException responseException = new ResponseException( new Date(), "Validation Falied!!", "Year can only be of 4 digits in the from YYYY") ;

		return new ResponseEntity( responseException, HttpStatus.BAD_REQUEST );

	}
	
	
}
