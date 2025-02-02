package in.vikas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping("/welcome")
	public String getWelComeMsg()
	{
		int i=10/0;
		String msg="WelCome to Programing..!";
		
		return msg;
	}
	
	
	
}
