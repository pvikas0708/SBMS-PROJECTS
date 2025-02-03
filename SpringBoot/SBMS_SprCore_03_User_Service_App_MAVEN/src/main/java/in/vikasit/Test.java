package in.vikasit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
	
		Car car = context.getBean(Car.class);
		
		car.drive();
	
	}

}
