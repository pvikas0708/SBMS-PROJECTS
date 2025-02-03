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

		/*
		  service.getEmpsWithSort("empId"); service.getEmpsWithSort("empName");
		  service.getEmpsWithSort("empSalary");*/
		 
		  //service.getEmpsWithPageination(3, 3);

		service.getEmpsByQBE();
	}

}
