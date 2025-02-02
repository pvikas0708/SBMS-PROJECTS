package in.vikas.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.bindings.Passanger;
import in.vikas.bindings.Ticket;
import in.vikas.service.TicketService;

@RestController
public class TicketRestController {

	@Autowired
	private TicketService service;

	@PostMapping(value = "/ticket", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passanger p) // responseentiti for custom response code
	{
		Ticket ticket = service.bookTicket(p);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/tickets", produces = "application/json")
	public ResponseEntity<Collection<Ticket>> getTickets() {
		Collection<Ticket> allTickets = service.getAllTickets();

		return new ResponseEntity<Collection<Ticket>>(allTickets, HttpStatus.OK);

	}
}
