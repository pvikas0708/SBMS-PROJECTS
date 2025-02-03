package in.vikas.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vikas.entity.Role;
import in.vikas.entity.User;
import in.vikas.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public void saveUser()
	{
		Role r1=new Role();
		r1.setRoleName("Admin");
		
		
		Role r2=new Role();
		r2.setRoleName("Manager");
		
		User u=new User();
		u.setUname("Vikas");
		u.setGender("Male");
		
		//set roles to user
		u.setRoles(Arrays.asList(r1,r2));
		
		//save parent
		userRepo.save(u);
	}
}
