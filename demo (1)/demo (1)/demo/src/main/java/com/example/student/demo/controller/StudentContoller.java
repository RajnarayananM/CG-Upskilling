package com.example.student.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.demo.model.Student;
import com.example.student.demo.repository.StudentRepo;
import com.example.student.demo.service.StudentService;



@RestController
@RequestMapping("/students")
public class StudentContoller {
	
	@Autowired
	StudentService studentservice;
	
	@Autowired
	StudentRepo studentrepo;
	
	@PostMapping("/addstudent")
	 public Student addstudent(@RequestBody Student student) {
	    	return studentservice.addStudent(student);
	    }
	
	 @GetMapping("/allStudents")
	    public List<Student> getAllStudents(){
	    	return studentservice.findAllStudent();
	    }

}
