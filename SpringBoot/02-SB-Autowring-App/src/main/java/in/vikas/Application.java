package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vikas.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		UserService service = context.getBean(UserService.class);

		// using IOC container we are going to get service call for calling service
		// class methods
		service.getUserName(100);

		// but it gives error -->(because "this.dao" is null) so generate seter for
		// UserDAO
	}

}
