package com.example.student.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.student.demo.model.Student;
import com.example.student.demo.repository.StudentRepo;




@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentrepo;
	
public Student addStudent(Student student) {
		
		return studentrepo.save(student);
	}

public List<Student> findAllStudent(){
	
	return studentrepo.findAll();
}



}
