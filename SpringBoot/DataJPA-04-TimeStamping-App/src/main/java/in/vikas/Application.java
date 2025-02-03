package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vikas.entity.ContactUsEntity;
import in.vikas.repo.ContactUsRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);

		ContactUsRepo bean = context.getBean(ContactUsRepo.class);

		ContactUsEntity entity = new ContactUsEntity();
		//entity.setcId(103);
		entity.setCname("SHYAM");
		entity.setCemail("shyam@gmail.com");
		entity.setCphno("55426321");

		bean.save(entity);
	}

}
