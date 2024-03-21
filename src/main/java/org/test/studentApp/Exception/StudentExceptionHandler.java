package org.test.studentApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.test.studentApp.dto.ResponseStructure;
import org.test.studentApp.util.ApplicationConstant;

@RestControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ResponseStructure<String>> hanldeSE(StudentException exception){
		
		ResponseStructure<String> structure
 = new ResponseStructure<>();
		
		structure
.setData(exception.getMessage());
		structure
.setMessage(ApplicationConstant.NOT_FOUND);
		structure
.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure
,HttpStatus.NOT_FOUND);
		
	}
	
}
