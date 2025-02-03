package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.vikas.entity.UserEntiry;

@Repository
public interface UserRepo extends JpaRepository<UserEntiry, Integer>{

	//select * from user_table where uname=:uname
	public UserEntiry  findByUname(String uname);
}
