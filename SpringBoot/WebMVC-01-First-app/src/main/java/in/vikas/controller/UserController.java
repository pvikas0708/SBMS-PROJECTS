package in.vikas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/c2")
public class UserController {

	public UserController() {
		System.out.println("UserController:: user Controller..!");
	}

	@GetMapping("/user")
	public ModelAndView getUser() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", 101);
		mav.addObject("name", "Raju");
		mav.addObject("email", "raju@gmail.com");

		mav.setViewName("user");
		return mav;

	}
}
