package in.vikas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.vikas.security.AppSecurity;

@Configuration
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig::Constructor...!");
	}

	@Bean // @Bean is manually object by developer for class he wants.(Customization
			// Object Creation).
	public AppSecurity createSecurityObj() {
		AppSecurity as = new AppSecurity("SHA-256");

		return as;
	}

}
