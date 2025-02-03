package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vikas.service.QuoteService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = 
				SpringApplication.run(Application.class, args);
		
		QuoteService bean = run.getBean(QuoteService.class);
		//bean.getQuotev1();
		bean.getQuotev2();
	}

}
