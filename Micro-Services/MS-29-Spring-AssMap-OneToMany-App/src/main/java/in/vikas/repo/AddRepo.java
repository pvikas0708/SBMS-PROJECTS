package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.Address;

public interface AddRepo extends JpaRepository<Address, Integer>{

}
