package in.vikas.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import in.vikas.entity.Employee;
import in.vikas.repo.EmployeeRepo;

@Service
public class EmployeeService {

	private EmployeeRepo empRepo;

	public EmployeeService(EmployeeRepo empRepo) {

		this.empRepo = empRepo;
	}

	public void getEmpsWithSort(String column) {
		// with CrudRepository no benifit of sorting
		// Iterable<Employee> findAll = empRepo.findAll(); //this is with crudRepository

		// with JPARepository gives benifit of sorting code
		Sort sort = Sort.by("empSalary").descending(); // by default it will be ascending.
		Iterable<Employee> findAll = empRepo.findAll(sort);

		Sort sort2 = Sort.by(column).ascending(); // permits to sor based on any column. multiple sorting avilable.
		Iterable<Employee> findAll1 = empRepo.findAll(sort2);
		// findAll.forEach(System.out::println);

		findAll1.forEach(e -> System.out.println(e));
	}

	// pagenation-> it is process of dividing totalnumber of records into multiple
	// pages.
	public void getEmpsWithPageination(int pageSize, int pageNo) {

		PageRequest of = PageRequest.of(pageNo - 1, pageSize); // page-1=> 1-1=0th page or 3-1 =>2nd page

		Page<Employee> findAll = empRepo.findAll(of);// return type is finsAll()

		List<Employee> content = findAll.getContent();

		content.forEach(System.out::println);

	}

	public void getEmpsByQBE() {
		Employee emp = new Employee();

		// if user select dept then set dept value to entity.
		emp.setEmpDept("Marketing");
		emp.setEmpGender("Male");
		emp.setEmpName("Veena");

		Example<Employee> of = Example.of(emp);

		List<Employee> findAll = empRepo.findAll(of);

		findAll.forEach(e -> System.out.println(e));
	}

}
