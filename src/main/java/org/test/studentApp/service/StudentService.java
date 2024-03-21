package org.test.studentApp.service;

import org.springframework.http.ResponseEntity;
import org.test.studentApp.dto.ResponseStructure;
import org.test.studentApp.model.Student;

import java.util.List;

public interface StudentService {

    ResponseEntity<ResponseStructure<Student>>  save(Student student);

    ResponseEntity<ResponseStructure<Student>> update(Student student, String studentId);

    ResponseEntity<ResponseStructure<List<Student>>> findAll();

    ResponseEntity<ResponseStructure<String>> delete(String studentId);
}
