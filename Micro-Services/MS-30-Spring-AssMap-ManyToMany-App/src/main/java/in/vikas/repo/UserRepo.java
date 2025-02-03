package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
