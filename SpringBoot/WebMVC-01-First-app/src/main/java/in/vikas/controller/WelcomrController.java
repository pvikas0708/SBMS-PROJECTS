package in.vikas.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // it identifies our java class as a spring Controller.
@RequestMapping("/c1")
public class WelcomrController {

	// this class responsible to handle user request and responses.

	public WelcomrController() {

		System.out.println("WelcomrController:: Controller...!");
	}

	@GetMapping("/welcome")
	public ModelAndView getWelComeMsg() {

		System.out.println("Get Welcome Method Executed..!");
		ModelAndView mav = new ModelAndView();

		// in form of key and value
		mav.addObject("msg1", "Welcome to Ashok IT..!");

		mav.addObject("msg2", "Good Morning..!");
		mav.setViewName("index"); // data will be sent to index file. (<p th:text="${msg}"></p>)

		return mav;
	}

	@GetMapping("/date")
	public ModelAndView getDate() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("date", new Date());

		mav.setViewName("index");

		return mav;

	}

}
