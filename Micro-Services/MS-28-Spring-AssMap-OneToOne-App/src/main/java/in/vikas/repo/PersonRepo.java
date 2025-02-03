package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
