package employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
