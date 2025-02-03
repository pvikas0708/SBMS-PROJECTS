package in.vikas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.vikas.entity.Employee;

@Repository // optional
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	@Query("from Employee") // for custom query
	public List<Employee> getAllEmpRecords();
	
	@Query("from Employee where empId=:id") // for custom query :id is named positional param
	public List<Employee> getEmpById(Integer id);
	
	
	
	// select * from employee where emp_dept= :dept
		public List<Employee> findByEmpDept(String empDept);
	// empDept is named positional parameter
	
	//select * from employee where emp_gender=:gender;
	public List<Employee> findByEmpGender(String gender);
	
	//select * from employee where EMP_DEPT='IT' and EMP_GENDER='Male';

	//to retrive with ,multiple conditions

	//select * from employee where EMP_GENDER= :gender and EMP_DEPT=:dept ;
	public List<Employee> findByEmpGenderAndEmpDept(String gender, String dept);
	
	//select * from employee where emp_salary >=:salary;
	public List<Employee> findByEmpSalaryGreaterThanEqual(float salary);
}
