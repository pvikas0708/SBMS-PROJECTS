package in.vikas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.vikas.bindings.Passenger;
import in.vikas.bindings.Ticket;
import reactor.core.publisher.Mono;

@Service
public class MakeMyTripService {

	public Mono<Ticket> bookTicket(Passenger p) {
		String apiUrl = "http://43.205.144.253:8080/ticket";

		WebClient webClient = WebClient.create();// WebClient is interface we can not create direct obj so using .create method

		Mono<Ticket> bodyToMono = webClient.post()// to post request
								.uri(apiUrl) // the URL you want to post
								.body(BodyInserters.fromValue(p))// BodyInserters class (what data you want to send in body)
								.retrieve() //retrieve response from response body
								.bodyToMono(Ticket.class); // (map that response to ticket body) mono-single(one ticket) fliux-bulk obj 

		return bodyToMono;

	}

	public Mono<Ticket[]> getAllTickets() {

		String apiUrl = "http://43.205.144.253:8080/tickets";
		
		WebClient webClient = WebClient.create();
		
		Mono<Ticket[]> bodyToMono = webClient.get()
											 .uri(apiUrl)
											 .retrieve()
											 .bodyToMono(Ticket[].class);
		return bodyToMono;
	}

}
