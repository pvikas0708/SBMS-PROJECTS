package in.vikas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoRestController {

	@GetMapping("/demo")
	public String getWelComeMsg() {
		String s = null;
		s.length();
		String msg = "hello........!";
		return msg;

	}

}
