package in.vikas.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.vikas.entity.Customer;

@Repository //optional
public interface CustomerRepo extends CrudRepository<Customer, Integer>{

	public Customer findByUname(String cuname);
}
