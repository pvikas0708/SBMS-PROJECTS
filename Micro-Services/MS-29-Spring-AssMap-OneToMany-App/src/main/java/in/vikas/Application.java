package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vikas.service.EmpService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmpService service = context.getBean(EmpService.class);
		
		//service.saveEmp();
		
		//service.getEmployee();
		
		//service.getAddress(); both records will come.
		
		//service.deleteEmp(); // when parent get deleted child aslo get deleted without parent child records are orphen

		service.saveAddress();
	}

}


