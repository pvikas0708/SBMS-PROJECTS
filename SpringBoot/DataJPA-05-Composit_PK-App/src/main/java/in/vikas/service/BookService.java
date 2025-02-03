package in.vikas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.vikas.entity.Book;
import in.vikas.entity.BookPK;
import in.vikas.repo.BookRepo;

@Service
public class BookService {

	@Autowired // when only one constructor is available in class @Autowired is not required
				// here are two
	private BookRepo bookRepo;

	public void saveBook() {
		BookPK pk = new BookPK(102, "JAVA");

		Book entity = new Book(1000, "James Gosling", pk);

		// repo is responsible to save records. so repo is to be injected to
		// service.(DI). =>take repo interface with variable fot this at top
		// DI will perform IOC in starter class.

		Book save = bookRepo.save(entity);

		System.out.println(save + "  " + "Record Saved..!");
	}

	public void getBookData() { // we have two primary key columns in composit PK class so we need to pass the
								// constructor value.

		BookPK pk = new BookPK(101, "JAVA");

		Optional<Book> findById = bookRepo.findById(pk);

		if (findById.isPresent()) {
			System.out.println(findById.get());
		}
	}	
	
	
	
}
