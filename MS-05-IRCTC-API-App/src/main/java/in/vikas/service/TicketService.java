package in.vikas.service;

import java.util.Collection;

import in.vikas.bindings.Passanger;
import in.vikas.bindings.Ticket;

public interface TicketService {

	public Ticket bookTicket(Passanger p);

	public Collection<Ticket> getAllTickets();

}
