package in.vikas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	// some pages will return view pages as response and some pages will return
	// direct response. for that we have to specify @responseBody
	@GetMapping("/demo4")
	@ResponseBody
	public String getMsg4() {
		String msg = "Welcome to programming..!";
		return msg;
	}

	@GetMapping("/demo3")
	public String getMsg3(Model model) // model interface=> to send the data from controller to UI in the form of key
										// and value
	{
		model.addAttribute("msg", "Hello, How are you?");

		return "index";
	}

	@GetMapping("/demo2/{name}")
	public ModelAndView getMsg2(@PathVariable("name") String name) {
		String msgtxt = "Hello Good Morning,  " + name;

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msgtxt);
		mav.setViewName("index");

		return mav;

	}

	@GetMapping("/demo1")
	public ModelAndView getMsg1(@RequestParam("name") String name) {
		String msgtxt = "Hello,  " + name;

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msgtxt);
		mav.setViewName("index");

		return mav;

	}
}
