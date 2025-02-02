package in.vikas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.vikas.binding.Passanger;
import in.vikas.binding.Ticket;
import in.vikas.service.MakeMyTripService;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService service;

	@PostMapping("/ticket") //when form is submitted ticket should be booked passenger data should go to
							// provider
	public String ticketBooking(@ModelAttribute("p")   Passanger p, Model model) {
		Ticket bookTicket = service.bookTicket(p);

		model.addAttribute("msg", "Your Ticked Booked,ID : "+bookTicket.getTicketNum());

		return "bookTicket";

	}

	@GetMapping("/book-ticket") // to show form where we can get passenger data
	public String bookTicket(Model model) {
		model.addAttribute("p", new Passanger());
		
		return "bookTicket";

	}

	@GetMapping("/") // to get all the tickets
	public String index(Model model) // MOdel int to send data from controller to UI
	{
		List<Ticket> allTickets = service.getAllTickets();

		model.addAttribute("tickets", allTickets); // key(tickets) value(allTickets) pair.

		return "index";

	}
	
	

}
