package in.vikas.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.binding.Customer;

@RestController
public class CustomerRestController {

	@DeleteMapping("/customer/{cid}")
	public String deleteCustomer(@PathVariable  Integer cid)
	{
		//DB logic to delete
		return "Customer Deleted.....!";
	}
	@PutMapping("/customer")
	public String updateCustomer(@RequestBody Customer c)
	{
		System.out.println(c);
		//DB logic to update the record
		return "Customer Updated.....!";
	}
	
	
	@PostMapping("/customer")
	public String addCustomer(@RequestBody Customer c) {
		System.out.println(c);
		// DB logic insert the  record
		return "Customer added...!";
	}

	@GetMapping("/customer")
	public Customer getCustomer1() // ResponseEntity for generating own status code
	{
		// DB logic to get record from DB

		Customer c = new Customer(101, "vikas", "vikas@gmail.com");

		return c;
	}

	@GetMapping("/customers")
	public List<Customer> getCustomer2() {
		Customer c1 = new Customer(102, "Balaji", "balaji@gmail.com");
		Customer c2 = new Customer(103, "Pooja", "pooja@gmail.com");
		Customer c3 = new Customer(104, "Aman", "aman@gmail.com");
		Customer c4 = new Customer(105, "Navnath", "navnath@gmail.com");

		List<Customer> customers = Arrays.asList(c1, c2, c3, c4);

		return customers;
	}
}
