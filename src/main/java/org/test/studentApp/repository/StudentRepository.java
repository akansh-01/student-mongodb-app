package org.test.studentApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.test.studentApp.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
