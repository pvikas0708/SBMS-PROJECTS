package in.vikas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.exception.NoUserFoundException;

@RestController
public class UserRestController {

	@GetMapping("user/{uid}")
	public String getNameById(Integer uid) {
		if (uid <= 100) {
			return "Vikas";
		} else {
			throw new NoUserFoundException("Invalis User uid");
		}
	}

}
