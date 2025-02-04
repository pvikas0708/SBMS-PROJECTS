package in.vikas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	// inside one restsontroller we can write n number of methods

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String msg = "Welcome to REST API...!";

		return msg;
	}

	@GetMapping("/greet")
	public String greetMsg(@RequestParam("name") String name) {
		String msg = "Good Morning...!" + name;

		return msg;
	}
}
