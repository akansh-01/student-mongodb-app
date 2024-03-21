package org.test.studentApp.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.studentApp.dto.ResponseStructure;
import org.test.studentApp.model.Student;
import org.test.studentApp.service.StudentService;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController{


	private final StudentService studentService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> save(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@PutMapping(value="/{studentId}")
	public ResponseEntity<ResponseStructure<Student>> update(@RequestBody Student student, @PathVariable(name = "studentId")String studentId) {
		
		return studentService.update(student,studentId);
	}
	
    @GetMapping	
	public ResponseEntity<ResponseStructure<List<Student>>> findAll() {
		
		return studentService.findAll();
	}

    @DeleteMapping(value = "/{studentId}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable(name = "studentId") String studentId) {
		
    	return studentService.delete(studentId);
	}
}
