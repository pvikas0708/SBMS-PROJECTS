package in.vikas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.vikas.entity.Employee;
import jakarta.transaction.Transactional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("from Employee")
	public List<Employee> getAllEmps();

	@Query(value = "select * from Employee", nativeQuery = true)
	public List<Employee> getAllEmpRecords();

	@Transactional
	@Modifying
	@Query("delete from Employee where empId=:eid")
	public void deleteEmp(Integer eid);
}
