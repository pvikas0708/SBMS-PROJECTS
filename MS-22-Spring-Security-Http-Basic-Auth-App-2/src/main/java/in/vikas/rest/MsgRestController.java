package in.vikas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MsgRestController {

	@GetMapping("/contact")
	public String contact()
	{
		return "contact: +91 9988776644";
	}
	@GetMapping("/greet")
	public String getGreetMsg() {
		return "Good Morning...!";
	}

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		return "WelCome to Spring Security programming...!";

	}
}
