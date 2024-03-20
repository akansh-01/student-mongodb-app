package org.test.studentApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.test.studentApp.dto.ResponseStrucutre;
import org.test.studentApp.util.ApplicationConstant;

@RestControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ResponseStrucutre<String>> hanldeSE(StudentException exception){
		
		ResponseStrucutre<String> strucutre = new ResponseStrucutre<>();
		
		strucutre.setData(exception.getMessage());
		strucutre.setMessage(ApplicationConstant.NOT_FOUND);
		strucutre.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStrucutre<String>>(strucutre,HttpStatus.NOT_FOUND);
		
	}
	
}
