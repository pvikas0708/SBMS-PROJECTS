package in.vikas;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component // to make it spring bean
public class Car implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("Car Started..!");
	}

	public void drive() {
		System.out.println("I am Driving Car....!");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Car stopped...!");

	}

}
