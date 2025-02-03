package in.vikas.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCmdRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("MyCmdRunner::Run Method..!!");
	}
}

//its a simple java class make it spring by using @component annotation.