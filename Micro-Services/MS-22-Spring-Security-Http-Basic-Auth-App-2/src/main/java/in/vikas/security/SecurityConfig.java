package in.vikas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // IOC container will create the Obj
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager inMemoryUsers()
	{
	  UserDetails vikasUser= User.withDefaultPasswordEncoder()
							.username("vikas")
							.password("vikas@123")
							.authorities("ADMIN")
							.build();
		
		
	 UserDetails poojaUser = User.withDefaultPasswordEncoder()
							.username("pooja")
							.password("pooja@123")
							.authorities("Developer")
							.build();
		
		return new InMemoryUserDetailsManager(vikasUser,poojaUser); //constructor injection
		
	}
	
	
	@Bean // represents that we are configuring one bean programatically
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/contact","/about", "/swagger-ui.html").permitAll()
				.anyRequest().authenticated())
				.formLogin();
		return http.build();
	}

}
