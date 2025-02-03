package in.vikas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/welcome")
	public String getWelcomeMsg(Model model) {

		model.addAttribute("msg", "welcome to programming..!");

		int i = 10 / 0;

		return "index";
	}

	@GetMapping("/greet")
	public String getGreetMsg(Model model) {
		model.addAttribute("msg", "Good Morning..!");

		return "index";

	}

}
