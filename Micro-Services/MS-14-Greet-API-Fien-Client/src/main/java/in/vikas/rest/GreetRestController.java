package in.vikas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.client.WelcomeApiClient;


	@RestController
	public class GreetRestController {
		
		@Autowired
		private WelcomeApiClient welcomeClient;
		
		@GetMapping("/greet")
		public String getGreetMsg() {
			
			String welcomeMsg = welcomeClient.invokeWelcomeMsg();
			
			String greetMsg = "Good Morning, ";
			
			return greetMsg.concat(welcomeMsg);
}
}
