package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.vikas.entity.Book;

@RepositoryRestResource(path = "books")
public interface BookRepo extends JpaRepository<Book, Integer>{

	//only for curd operations
}
