package com.example.student.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.student.demo.model.Student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class Student_junit {
 
    @Test
    public void testStudentDetails() {
        // Create a Student object
        Student student = new Student();
        student.setName("Raj");
        student.setAge(23);
        student.setSalary(15000);
 
        // Verify student details
        assertEquals("Raj", student.getName());
        assertEquals(23, student.getAge());
        assertEquals(15000, student.getSalary(), 0.001); // Using delta for double comparison
    }
 
    @Test
    public void testDefaultStudentValues() {
        // Create a Student object with default values
        Student student = new Student();
 
        // Verify default values
        assertNull(student.getName());
        assertEquals(0, student.getAge());
        assertEquals(0, student.getSalary(), 0.001);
    }
}
