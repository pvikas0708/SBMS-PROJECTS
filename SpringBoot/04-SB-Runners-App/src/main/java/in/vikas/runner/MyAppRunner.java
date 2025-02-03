package in.vikas.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyAppRunner::Run Method..!!");

	}

}

//its a simple java class make it spring by using @component annotation.