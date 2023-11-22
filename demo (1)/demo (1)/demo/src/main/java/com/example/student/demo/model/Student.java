package com.example.student.demo.model;

import Model.Students;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;



public class Student {
	
	private String name;
	
	private int age;
	
	private long salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Student(String name, int age, long salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
