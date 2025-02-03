package in.vikas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.binding.AuthRequest;
import in.vikas.entity.UserEntiry;
import in.vikas.service.JwtService;
import in.vikas.service.MyUserDetailsService;

@RestController
@RequestMapping("/api") // class level URL pattern
public class UserRestController {

	@Autowired
	private MyUserDetailsService service;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtService jwt;
	

	// 1)register method =. Post Request Method

	@PostMapping("/register")
	public String registerUser(@RequestBody  UserEntiry user) {

		// when User sends req to reg we are going to take user data that user data we
		// are going to encode using pwd encoder. pwdencoder we are going to configure
		// as bean, then we are setting the encoded pwd to user then we will get normal
		// pwd then we will set the encoded pwd. then we are saving the user and
		// returning the msg to user.
		String encodePwd = encoder.encode(user.getUpwd());// gives us encoded pwd
		user.setUpwd(encodePwd);

		// User record saves directly in DB which we should not=> so PasswordEncoder
		// interface help to encode pwd
		boolean saveUser = service.saveUser(user);// returns boolean value True/False

		if (saveUser) {
			return "User Registered..!";
		} else {
			return "User not Registration failed..!";
		}

	}

	// 2)login method (post method)=> Its not a normal login its a spring security
	// login. so create
	// binding class with uname and pwd create setter/getter.

	@PostMapping("/login")
	public String userAuthentication(@RequestBody AuthRequest request) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getUname(),
				request.getPwd());

		try {
			// to this authManager method we need to pass uname and pwd as token so create
			// AuthenticationManager obj 
			Authentication auth = authManager.authenticate(token); // returns Authentication object
			if (auth.isAuthenticated()) {
				// if Authentication is successful generate JWT token for user as aresponse.
				String jwtToken = jwt.generateToken(request.getUname());
				return jwtToken; // in real time token will be stored in DB
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return "Authentication";
	}

	// 3) Welcome method this is our secured method.
	@GetMapping("/welcome")
	public String welcomeMsg()
	{ //registration anybody can access, but welcome method can only be accessed with JWT TOKEN.
		// we need to configure Authentication provider in AppConfig class
		
		return "Welcome to programming..!";
	}

	@GetMapping("/greet")
	public String greetMsg()
	{ //registration anybody can access, but welcome method can only be accessed with JWT TOKEN.
		// we need to configure Authentication provider in AppConfig class
		
		return "Good Morning ...!";
	}

}
