package in.vikas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {

	// controllers are loosely couples with presentation tech we can use either JSP
	// or thymeleaf.
	
	@GetMapping("/welcome")
	public String welComeMsg1(Model model) {
		model.addAttribute("msg1", "WelCome to Spring..!");

		return "index";
	}
	

	@GetMapping("/greet")
	public String welComeMsg2(Model model) {
		model.addAttribute("msg2", "Good Evening..!");

		return "index";
	}
}
