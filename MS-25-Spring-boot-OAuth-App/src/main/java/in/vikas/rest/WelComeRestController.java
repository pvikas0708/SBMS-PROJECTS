package in.vikas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelComeRestController {

	@GetMapping("/")
	public String getmsg()
	{
		return "WelCome to Programming..!";
	}
}
