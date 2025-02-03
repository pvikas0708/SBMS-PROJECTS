package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.Address;
import in.vikas.entity.Emp;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
