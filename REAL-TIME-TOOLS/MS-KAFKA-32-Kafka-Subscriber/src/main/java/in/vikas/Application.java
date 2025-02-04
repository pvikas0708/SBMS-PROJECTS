package in.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.vikas.constants.AppConstants;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//kafka listner
	@KafkaListener(topics=AppConstants.TOPIC,groupId = "group_vikas_order")
	public void subscribeMsg(String order)
	{
		System.out.println("**** Msg Received From Kafka ***::");
		System.out.println(order);
		
		//logic
	}
	

}
