package in.vikas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vikas.entity.Book;
import in.vikas.repo.BookRepository;

@Service
public class BooksServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {

		return bookRepo.findByActiveSW("Y");
	}

	@Override
	public boolean saveBook(Book book) {

		book.setActiveSW("Y");
		
		Book savedBook = bookRepo.save(book);

		/*
		 * if (savedBook.getBookId() != null) { return true; }
		 * 
		 * return false;
		 */

		// OR

		return savedBook.getBookId() != null;
	}
	
	@Override
	public void deleteBook(Integer bookId) {
		//Hard Delete.
		//bookRepo.deleteById(bookId);

		//Soft Delete.
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent())
		{
			Book book = findById.get();
			book.setActiveSW("N");
			bookRepo.save(book);
		}
	}
	
	@Override
	public Book getBookById(Integer bookId) {
	
		Optional<Book> findById = bookRepo.findById(bookId);
		
		if(findById.isPresent())
		{
			findById.get();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


