package in.vikas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.vikas.entity.Book;
import in.vikas.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	// to capture form data when form is submitted
	@GetMapping("/index") // to load the page
	public String index(@ModelAttribute("book") Book book) {
		
		//model.addAttribute("book", new Book()); we can use @ModelAttribute
		return "index";
	}

	@GetMapping("/edit")
	public ModelAndView editBook(@RequestParam("bookId") Integer bookId) {
		Book bookObj = service.getBookById(bookId);

		ModelAndView mav = new ModelAndView();
		mav.addObject("book", bookObj);// here form is coming with records. editing already available records.
		mav.setViewName("index");

		// we are using index page for both edit and delete.

		// index method and edit methods are almost same.

		return mav;

	}

	@PostMapping("/book") // to insert book record in table.
	public ModelAndView saveBook(Book book) {
		ModelAndView mav = new ModelAndView();

		boolean status = service.saveBook(book);

		if (status) {
			mav.addObject("succMsg", "Book Saved");
		} else {
			mav.addObject("errMsg", "Failed to save");
		}

		mav.setViewName("index");
		return mav;

	}

	@GetMapping("/books") // executes when we click on view all book hiperlink
	public ModelAndView getBooks() {
		ModelAndView mav = new ModelAndView();

		List<Book> allBooks = service.getAllBooks();

		mav.addObject("books", allBooks);

		mav.setViewName("bookView");
		return mav;
	}

	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId") Integer bookId) {
		// when click delete BookId should come to controller method then by
		// @RequestParam("bookId") annotation controller will get the bookId based on
		// key and it will get the value and give that value to our method as a
		// parameter
		// controller will call service methods by passing bookId then
		// service method will call repository to delete that book
		// when record deleted we want all the latest remaining records on same page

		service.deleteBook(bookId);
		ModelAndView mav = new ModelAndView();

		List<Book> allBooks = service.getAllBooks();

		mav.addObject("books", allBooks);

		mav.setViewName("bookView");
		return mav;
	}

}
