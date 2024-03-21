package org.test.studentApp.service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.test.studentApp.Exception.StudentException;
import org.test.studentApp.dao.StudentDao;
import org.test.studentApp.dto.ResponseStructure;
import org.test.studentApp.model.Student;
import org.test.studentApp.util.ApplicationConstant;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public ResponseEntity<ResponseStructure<Student>> save(Student student) {

        ResponseStructure<Student> structure
                = new ResponseStructure<>();

        structure
                .setData(studentDao.save(student));
        structure
                .setMessage(ApplicationConstant.ACCOUNT_SAVED);
        structure
                .setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<ResponseStructure<Student>>(structure
                , HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Student>> update(Student student, String studentId) {

        Optional<Student> recStudent = studentDao.findById(studentId);

        ResponseStructure<Student> structure = new ResponseStructure<>();

        if (recStudent.isPresent()) {
            student.setStudentId(studentId);

            structure.setData(studentDao.save(student));
            structure.setMessage(ApplicationConstant.UPDATE_STUDENT);
            structure.setStatusCode(HttpStatus.ACCEPTED.value());

            return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.ACCEPTED);
        }

        throw new StudentException(ApplicationConstant.CAN_NOT_UPDATE);
    }

    public ResponseEntity<ResponseStructure<List<Student>>> findAll() {

        List<Student> students = studentDao.findAll();
        ResponseStructure<List<Student>> structure
                = new ResponseStructure<>();

        if (students.isEmpty()) {

            throw new StudentException(ApplicationConstant.STUDENT_NOT_PRESENT);
        }

        structure
                .setData(students);
        structure
                .setMessage(ApplicationConstant.STUDENT_DETAILS);
        structure
                .setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<ResponseStructure<List<Student>>>(structure
                , HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> delete(String id) {

        Optional<Student> recStudent = studentDao.findById(id);
        ResponseStructure<String> structure
                = new ResponseStructure<>();

        if (recStudent.isPresent()) {

            studentDao.deleteById(id);
            structure
                    .setData(ApplicationConstant.STUDENT_FOUND);
            structure
                    .setMessage(ApplicationConstant.STUDENT_DELETED);
            structure
                    .setStatusCode(HttpStatus.OK.value());

            return new ResponseEntity<ResponseStructure<String>>(structure
                    , HttpStatus.OK);
        }

        throw new StudentException(ApplicationConstant.STUDENT_NOT_DELETED);
    }

}
