Student Mongo App
This project is a simple CRUD (Create, Read, Update, Delete) application built with Spring Boot and MongoDB. It allows users to manage student data by performing basic operations like adding, viewing, updating, and deleting student information.

Features
Create: Add a new student to the MongoDB database.
Read: Retrieve the list of students and their details from the database.
Update: Modify details of an existing student.
Delete: Remove a student from the database.
Technologies Used
Spring Boot (Backend Framework)
MongoDB (NoSQL Database)
Java 17 (Programming Language)
Maven (Build Tool)
Prerequisites
Before you begin, ensure you have the following installed:

Java 17 or later
Maven to build the project
MongoDB installed and running locally or using a cloud-based service like MongoDB Atlas
Postman or curl (optional, for API testing)

Clone the repository:
Copy code
git clone https://github.com/your-username/student-mongo-app.git

Navigate to the project directory:
Copy code
cd student-mongo-app


Here’s an updated version of the README.md file considering that you’ve used Spring Boot for the backend:

Student Mongo App
This project is a simple CRUD (Create, Read, Update, Delete) application built with Spring Boot and MongoDB. It allows users to manage student data by performing basic operations like adding, viewing, updating, and deleting student information.

Features
Create: Add a new student to the MongoDB database.
Read: Retrieve the list of students and their details from the database.
Update: Modify details of an existing student.
Delete: Remove a student from the database.
Technologies Used
Spring Boot (Backend Framework)
MongoDB (NoSQL Database)
Java 17 (Programming Language)
Maven (Build Tool)
Prerequisites
Before you begin, ensure you have the following installed:

Java 17 or later
Maven to build the project
MongoDB installed and running locally or using a cloud-based service like MongoDB Atlas
Postman or curl (optional, for API testing)
Installation & Setup
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/student-mongo-app.git
Navigate to the project directory:

bash
Copy code
cd student-mongo-app
Configure MongoDB:

Ensure your MongoDB server is running.
If you are using a local MongoDB server, the default configuration will connect to mongodb://localhost:27017/studentDB. If you're using MongoDB Atlas, update your configuration.
Update the MongoDB connection URL in application.properties:
properties
spring.data.mongodb.uri=mongodb://localhost:27017/studentDB
