package in.vikas.binding.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vikas.binding.Book;

@RestController
public class BookRestController {
	@PostMapping(
			value = "book", 
			consumes = {"application/json","application/xml"},
			produces = "text/plain"
			)
	public String addBook(@RequestBody Book b) 
	{
		System.out.println(b);
		//logic to save in DB
		return "Book Added";
	
		
	}
	@GetMapping(value = "/book", 
			produces = { "application/json", "application/xml" })
	public Book getBook() {
		Book book = new Book(101, "java", 543.00);
		return book;
	}
}
