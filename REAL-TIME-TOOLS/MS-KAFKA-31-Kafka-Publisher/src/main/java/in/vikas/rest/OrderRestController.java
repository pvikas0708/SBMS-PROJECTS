package in.vikas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.binding.Order;
import in.vikas.service.OrderService;

@RestController
public class OrderRestController {

	@Autowired
	public OrderService orderService;
	
	@PostMapping("/order")
	public String placeOrder(@RequestBody  Order order)
	{
		orderService.publishMsg(order);
		
		return orderService.publishMsg(order);
	}
}
