package in.vikas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.entity.Customer;
import in.vikas.repo.CustomerRepo;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepo crepo;

	@Autowired // DI
	private PasswordEncoder pwdEncoder;
	
	@Autowired
	private AuthenticationManager authManager; //using this we will perform uathentication
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody Customer c)
	{
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(c.getUname(), c.getPwd());
		
		try {
			Authentication authenticate = authManager.authenticate(token);
			if(authenticate.isAuthenticated())
			{
				return new ResponseEntity<String>("WelCome to Programming..!", HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			// logger why exception occered
		}
			return new ResponseEntity<String>("Invalid Credentials..!", HttpStatus.BAD_REQUEST);
		
	}

	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer customer) {

		String encodedPwd = pwdEncoder.encode(customer.getPwd()); //to encode password

		customer.setPwd(encodedPwd); // this will encode pwd and will return pwd for us.

		crepo.save(customer);
		return "User Registered...!";

	}
}
