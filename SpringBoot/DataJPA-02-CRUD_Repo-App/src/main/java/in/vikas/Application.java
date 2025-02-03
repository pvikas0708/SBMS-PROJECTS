package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vikas.entity.Employee;
import in.vikas.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		EmployeeService service = context.getBean(EmployeeService.class);

		// service.saveEmployee(); // for saving single emp

		// service.saveMultipleEmployee(); // for multiple emp saving

		// service.getEmp(); // to get single emp

		// service.getMultipleEmp(); //to get multiple emp

		//service.getAllEmps(); // to get all emps
		
		//service.getEmpsByDept("IT"); // to find by custom inoute rather than PK.
		
		//service.getEmpsByGender("Male");
		
		//service.getEmpsByGenderAndDept("Male","ITs");
		
		//service.getEmpsBySalary(15000.00f);
		
		//service.getAllEmpRecords();
		
		service.getEmpById(101);
	}

}
