package in.vikas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctxt = new ClassPathXmlApplicationContext("beans.xml");

		PaymentProcessor pp = ctxt.getBean(PaymentProcessor.class);

		pp.ProcessPayment(1200.50);
	}
}
