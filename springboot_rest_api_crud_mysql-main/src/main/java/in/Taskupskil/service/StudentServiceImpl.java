package in.Taskupskil.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Taskupskil.binding.Student;
import in.Taskupskil.repo.StudentRepository;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public String upsert(Student student) {

		studentRepo.save(student); // upsert (insert / update based on PK)

		return "success";
	}

	@Override
	public Student getById(Integer cid) {
		Optional<Student> findById = studentRepo.findById(cid);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if (studentRepo.existsById(cid)) {
			studentRepo.deleteById(cid);
			return "Delete Success";
		} else {
			return "No Record Found";
		}
	}

}
