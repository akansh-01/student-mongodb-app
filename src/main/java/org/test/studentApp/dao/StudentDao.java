package org.test.studentApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.studentApp.model.Student;
import org.test.studentApp.repository.StudentRepository;

@Component
public class StudentDao {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {

        return studentRepository.save(student);
    }

    public Optional<Student> findById(String id) {

        return studentRepository.findById(id);
    }

    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    public boolean deleteById(String id) {

        Optional<Student> recStudent = studentRepository.findById(id);
        if (recStudent.isPresent()) {

            studentRepository.delete(recStudent.get());
            return true;
        }
        return false;
    }

}
