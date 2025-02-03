package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.Book;
import in.vikas.entity.BookPK;

public interface BookRepo extends JpaRepository<Book, BookPK> {

	// when we have single primary key we will give Integer if multiple PK then PK
	// class(BookPK)
}
