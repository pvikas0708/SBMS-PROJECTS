package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vikas.entity.Employee;
import in.vikas.repo.EmployeeRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmployeeRepo bean = context.getBean(EmployeeRepo.class);
		
		Employee emp=new Employee();
		
		emp.setEname("Raju");
		emp.setEsal(15000.00);
		
		Employee save = bean.save(emp);
		
		System.out.println(save+" "+"Record Saved..!");
	
	}

}
