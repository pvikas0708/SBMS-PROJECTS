package in.vikas.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Controller
public class DataRestController {

	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDB", name = "CircuitActivity")
	public String getData() {
		System.out.println("Redis Method Called..!");

		int i = 10 / 0;
		return "Redis Data sent to your Email..!";

	}

	public String getDataFromDB(Throwable t) {
		System.out.println("DB Method Called..!");

		return "DB Data sent to your Email..!";

	}
}
