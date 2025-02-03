package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
