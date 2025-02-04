package in.vikas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.vikas.binding.Order;
import in.vikas.constants.AppConstants;

@Service
public class OrderService {

	@Autowired
	public KafkaTemplate<String , Order> kafkaTemplete;

	public String publishMsg(Order order)
	{
		//kafkaTemplete is pre-defined class which is used to send Msg to topic
		kafkaTemplete.send(AppConstants.TOPIC, order);
		
		return "Msg Published to Kafka Topic";
	}

}
