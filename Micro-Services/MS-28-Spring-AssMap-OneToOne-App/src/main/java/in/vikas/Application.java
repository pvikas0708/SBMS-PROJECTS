package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vikas.service.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		PersonService service = context.getBean(PersonService.class);
		
		//service.savePerson(); // when we retrieve parent record child record is also coming
		
		//service.getPerson(); // using Left join to retrieve record
		
		//service.getPasspoert(); // using Left join to retrieve record
		
		service.deletePerson(); // both parent and child records are deleted.
	}

}
