package org.test.studentApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.test.studentApp.Exception.StudentException;
import org.test.studentApp.dao.StudentDao;
import org.test.studentApp.dto.ResponseStrucutre;
import org.test.studentApp.model.Student;
import org.test.studentApp.util.ApplicationConstant;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public ResponseEntity<ResponseStrucutre<Student>> save(Student student) {
		
		ResponseStrucutre<Student> strucutre = new ResponseStrucutre<>();
		
		strucutre.setData(studentDao.save(student));
		strucutre.setMessage(ApplicationConstant.ACCOUNT_SAVED);
		strucutre.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStrucutre<Student>>(strucutre,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStrucutre<Student>> update(Student student,String studentId){
		
		Optional<Student> recStudent = studentDao.findById(studentId);
		
		ResponseStrucutre<Student>structure = new ResponseStrucutre<>();
		
		if(recStudent.isPresent()) {
			
			Student dbStudent = recStudent.get();
			//BeanUtil.copi
			dbStudent.setName(student.getName());
			dbStudent.setPhone(student.getPhone());
			dbStudent.setEmail(student.getEmail());
			dbStudent.setPassword(student.getPassword());
			dbStudent.setAge(student.getAge());
			dbStudent.setGender(student.getGender());
			dbStudent.setRollno(student.getRollno());
			

			structure.setData(studentDao.save(dbStudent));
			structure.setMessage(ApplicationConstant.UPDATE_STUDENT);
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			System.out.println("Updated");
			return new ResponseEntity<ResponseStrucutre<Student>>(structure,HttpStatus.ACCEPTED);
		}
		
		throw new StudentException(ApplicationConstant.CAN_NOT_UPDATE);
	}
	
	public ResponseEntity<ResponseStrucutre<List<Student>>> findAll(){
		
		List<Student> students= studentDao.findAll();
		ResponseStrucutre<List<Student>> strucutre= new ResponseStrucutre<>();
		
         if(students.isEmpty()) {
        	 
        	 throw new StudentException(ApplicationConstant.STUDENT_NOT_PRESENT);
         }		
         
         strucutre.setData(students);
         strucutre.setMessage(ApplicationConstant.STUDENT_DETAILS);
         strucutre.setStatusCode(HttpStatus.OK.value());
         
         return new ResponseEntity<ResponseStrucutre<List<Student>>>(strucutre,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStrucutre<String>> delete(String id){
		
		Optional<Student> recStudent = studentDao.findById(id);
		ResponseStrucutre<String> strucutre = new ResponseStrucutre<>();
		
		if(recStudent.isPresent()) {
			
			studentDao.deleteById(id);
			strucutre.setData(ApplicationConstant.STUDENT_FOUND);
			strucutre.setMessage(ApplicationConstant.STUDENT_DELETED);
			strucutre.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStrucutre<String>>(strucutre,HttpStatus.OK);
		}
		
		throw new StudentException(ApplicationConstant.STUDENT_NOT_DELETED); 
	}
	
}
