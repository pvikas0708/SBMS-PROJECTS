package in.vikas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping(value = "/admin")
	public String admin() {
		return "<h3>WelCome Admin</h3>";

	}

	@GetMapping(value = "/user")
	public String user() {
		return "<h3>Hello User, WelCome</h3>";

	}

	@GetMapping(value = "/")
	public String welCome() {
		return "<h3>WelCome Admin</h3>";

	}
}
