package in.vikas.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vikas.entity.Employee;
import in.vikas.repo.EmployeeRepo;

@Service
public class EmployeeService {

	private EmployeeRepo empRepo;

	@Autowired // if there is only one constructor with one param its optional to write
				// @autowire
	public EmployeeService(EmployeeRepo empRepo) {

		this.empRepo = empRepo;
		System.out.println(this.empRepo.getClass().getName());
	}

	// to find single record
	public void getEmp() {
		Optional<Employee> findById = empRepo.findById(102); // return type of findbyId is optional object

		// optional is class in java 1.8 version which used to avoid nullpointer
		// exception. (if record not available then it will give nullpointer exception)

		if (findById.isPresent()) // check if record is present or not by isPresent()
		{
			Employee employee = findById.get();

			System.out.println(employee);
		}

	}

	// to find multiple record
	public void getMultipleEmp() {
		List<Integer> empIds = Arrays.asList(101, 102, 103);

		Iterable<Employee> itr = empRepo.findAllById(empIds);

		itr.forEach(System.out::println);

	}
	// to find all record

	public void getAllEmps() {
		Iterable<Employee> findAll = empRepo.findAll();

		findAll.forEach(System.out::println);
	}
	
	//to find records with coustom inpute 
		public void getEmpsByDept(String empDept)
	{
		List<Employee> emps = empRepo.findByEmpDept(empDept);
		emps.forEach(System.out::println);
	}

	//to find records with coustom inpute 
		public void getEmpsByGender(String Gender)
	{
		List<Employee> emps = empRepo.findByEmpGender(Gender);
		emps.forEach(System.out::println);
	}
	
	// for multiple condition in one query
	public void getEmpsByGenderAndDept(String gender,String dept)
	{
		List<Employee> emps = empRepo.findByEmpGenderAndEmpDept(gender,dept);
		emps.forEach(System.out::println);
	}
	
	// to get data based on salary condition
	public void getEmpsBySalary(float salary)
	{
		List<Employee> emps = empRepo.findByEmpSalaryGreaterThanEqual(salary);
		emps.forEach(System.out::println);
	}
	
	//to ge all record with custom method
	public void getAllEmpRecords()
	{
		List<Employee> emps = empRepo.getAllEmpRecords();
		emps.forEach(System.out::println);
		
	}
	
	//to find emp by id with custom method
	public void getEmpById(Integer id)
	{
		List<Employee> empById = empRepo.getEmpById(id);
		System.out.println(empById);
	}
	
	// to insert or update sngle record.
	public void saveEmployee() {
		Employee emp = new Employee();

		emp.setEmpId(101);
		emp.setEmpName("Vikas");
		emp.setEmpDept("IT");
		emp.setEmpGender("Male");
		emp.setEmpSalary(18000.00);

		empRepo.save(emp);

		// if this same method called again without changing data then only select query
		// will be executed.
	}

	// to save multiple employees

	public void saveMultipleEmployee() {
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		emp1.setEmpId(102);
		emp1.setEmpName("Pooja");
		emp1.setEmpDept("Admin");
		emp1.setEmpGender("FeMale");
		emp1.setEmpSalary(30000.00);

		emp2.setEmpId(103);
		emp2.setEmpName("Balaji");
		emp2.setEmpDept("Sales");
		emp2.setEmpGender("Male");
		emp2.setEmpSalary(25000.00);

		// first we need to convert emp1 & emp2 to one collection use Array List

		List<Employee> emps = Arrays.asList(emp1, emp2);

		empRepo.saveAll(emps);
	}

}
