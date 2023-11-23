package in.Taskupskil.service;

import java.util.List;

import in.Taskupskil.binding.Student;

public interface StudentService {

	public String upsert(Student student);

	public Student getById(Integer cid);

	public List<Student> getAllStudents();

	public String deleteById(Integer cid);

}
