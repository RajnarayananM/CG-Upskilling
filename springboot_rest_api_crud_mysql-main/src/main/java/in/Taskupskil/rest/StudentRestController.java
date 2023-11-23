package in.Taskupskil.rest;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.Taskupskil.binding.Student;
import in.Taskupskil.service.StudentService;



@RestController
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		String status = studentService.upsert(student);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/student/{cid}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer cid) {
		Student student = studentService.getById(cid);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();
		return new ResponseEntity<>(allStudents, HttpStatus.OK);
	}

	@PutMapping("/student")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		String status = studentService.upsert(student);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/student/{cid}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer cid) {
		String status = studentService.deleteById(cid);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
