package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.ContactUsEntity;

public interface ContactUsRepo extends JpaRepository<ContactUsEntity, Integer>{

	
}
