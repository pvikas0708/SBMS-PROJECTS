package in.vikas.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@Value("${msg}") // identify the key in yml as a msg => key available in welcome.yml & greet.yml
						// based on app name
	private String msgTxt;

	@GetMapping("/")
	public String getMsg() {
		return msgTxt;
	}
}
