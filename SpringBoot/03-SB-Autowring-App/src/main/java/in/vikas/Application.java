package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vikas.service.IUserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		IUserService userService = context.getBean(IUserService.class);

		userService.registerUser("vikas", "vikas0708@gmail.com", "vikas@123");
	}

}
