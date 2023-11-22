package com.example.student.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.student.demo.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, Integer>{

}
