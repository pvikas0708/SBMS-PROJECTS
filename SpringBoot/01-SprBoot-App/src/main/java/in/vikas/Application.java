package in.vikas; //base package because start class is here.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"in.vikas","com.tcs"})
public class Application {

	public static void main(String[] args) {
		System.out.println("Hello..!");
		
		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);
		
	}
	
}
