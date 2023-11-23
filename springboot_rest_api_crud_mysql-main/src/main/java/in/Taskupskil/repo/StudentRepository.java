package in.Taskupskil.repo;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import in.Taskupskil.binding.Student;

public interface StudentRepository extends JpaRepository<Student, Serializable> {

}
