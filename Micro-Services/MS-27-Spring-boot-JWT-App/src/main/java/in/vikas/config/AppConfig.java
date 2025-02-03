package in.vikas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.vikas.service.MyUserDetailsService;

@Configuration
public class AppConfig {

	@Autowired
	private MyUserDetailsService userDtlsSvc;

	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder(); //to encode the password.
	}

	@Bean //for where it has to load the user data for the Authentication purpose.
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = 
				new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDtlsSvc);
		authenticationProvider.setPasswordEncoder(pwdEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	//to cstomise security configure in our Application. to 
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception
	{
		//TODO: logic
		return http.build();
	}
	
	
	
	
}
