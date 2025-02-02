package in.vikas.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	//SpringBoot deciding status code
	//its a pure backend applicatipn so no need of model interface(UI)
	@GetMapping("/welcome") //consumer can send get request to access method.(wont have request body)
	public String getWelcomeMsg()
	{
		String msg="Welcome to REST API...!";
		return msg;
	}
	
	//not sending any response to consumer and for customized response to customer
	@GetMapping("/action")
	public ResponseEntity doAction()
	{
		System.out.println("doAction() method called...!");
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204 no contend code
	}
	
	//for customized response to customer
	@GetMapping("/custom/{name}") 
	public ResponseEntity<String> custom(@PathVariable("name")String name)
	{
		String msg="Customed Response...!"+name;
		
		return new  ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/greet")
	public String greetMsg(@RequestParam("name") String name)
	{
		String msg="Welcome to REST API...,"+name;
		return msg;
	}
	
}
