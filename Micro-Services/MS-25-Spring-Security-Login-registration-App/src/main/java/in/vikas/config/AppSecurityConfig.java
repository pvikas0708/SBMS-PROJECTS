package in.vikas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.vikas.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Autowired
	private MyUserDetailsService userdtlsSvc;
	
	@Bean // we are going to represent this as a spring bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();

	}
		
	@Bean //permits all the requests
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

		return http.csrf()
				.disable()
				.authorizeRequests()
				.anyRequest()
				.permitAll() //permits all the requests
				.and()
				.build();

	}
}
