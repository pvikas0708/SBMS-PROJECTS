package in.vikas.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.vikas.entity.Customer;
import in.vikas.repo.CustomerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private CustomerRepo crepo;
	
	//bellow logic to retrive record from DB => security should call this method
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer c = crepo.findByUname(username); //customer records will be represent in the form of user object
		
		return new  User(c.getUname(), c.getPwd(), Collections.emptyList()); // User is pre defined class in spring security
		
	}
}
