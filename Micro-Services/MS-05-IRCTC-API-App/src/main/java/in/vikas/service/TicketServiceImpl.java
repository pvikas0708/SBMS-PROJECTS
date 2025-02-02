package in.vikas.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.vikas.bindings.Passanger;
import in.vikas.bindings.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	Map<Integer, Ticket> db = new HashMap<>(); // to store tickets

	@Override
	public Ticket bookTicket(Passanger p) {

		Ticket t = new Ticket();
		Random r = new Random(100);
		int id = r.nextInt(100);
		t.setTicketNum(id);

		BeanUtils.copyProperties(p, t); // copies the properties from one object to another object (p=>t)

		t.setStatus("CONFIRMED");

		db.put(id, t);

		return t;
	}

	@Override
	public Collection<Ticket> getAllTickets() {

		return db.values();
	}

}
