package in.vikas;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Motor {

	@PostConstruct
	public void inIt() {
		System.out.println("Motor - init() method");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Motor - destroy() method");
	}
}
