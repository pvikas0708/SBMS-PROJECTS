package in.vikas.entity.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.vikas.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{

	
}
