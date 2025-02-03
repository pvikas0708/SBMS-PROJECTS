package in.vikas.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.vikas.entity.UserEntiry;
import in.vikas.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;

	@Override // this method is used to retrieve the user records for authentication purpose.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntiry entiry = repo.findByUname(username); // returns entity object

		return new User(entiry.getUname(), entiry.getUpwd(), Collections.emptyList()); // returns Spring security User
														// object (rolles are empty so collections empty list())
	}
	
	//Saving User Data
	public boolean saveUser(UserEntiry user)
	{
		 user = repo.save(user); // returns entity
		 
		 return user.getUserid()!=null; // if not equal to null then returns true or false (if record saved returns true else false).
	}

}
