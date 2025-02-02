package in.vikas.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.vikas.binding.Passanger;
import in.vikas.binding.Ticket;

@Service
public class MakeMyTripService {

	public Ticket bookTicket(Passanger p) {
		// consumer logic =>IRCTC is provider running in AWS cloud

		String apiUrl = "http://43.205.144.253:8080/ticket";

		// RestTemplate=> it is pre defined class in Spring web MVC to send HTTP request
		// to URL
		RestTemplate rt = new RestTemplate();

		// rt will convert our object to json and will josn to provider
		// in provider RestController will do this job

		ResponseEntity<Ticket> forEntity = 
				rt.postForEntity(apiUrl, p, Ticket.class);// (URL, obj, response type) sending post request
		// we will get more than one ticket thats why Ticket[].class
		// String.class=>will give raw json Ticket.class will convert raw json to Ticket
		// Object

		Ticket body = forEntity.getBody();
		// body is Ticket object

		return body;

	}

	public List<Ticket> getAllTickets() {
		String apiUrl = "http://43.205.144.253:8080/ticket";

		RestTemplate rt = new RestTemplate();

		ResponseEntity<Ticket[]> forEntity = rt.getForEntity(apiUrl, Ticket[].class); // sending get request
																						// (URL,response type)

		Ticket[] body = forEntity.getBody(); // we will get more than one ticket thats why Ticket[].class

		List<Ticket> tickets = Arrays.asList(body);

		return tickets;

	}

}
