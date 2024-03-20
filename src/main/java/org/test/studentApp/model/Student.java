package org.test.studentApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	private String studentId;
	private int rollno, age;
	private String name;
	private long phone;
	private String email;
	private String password;
	private String gender;

}
