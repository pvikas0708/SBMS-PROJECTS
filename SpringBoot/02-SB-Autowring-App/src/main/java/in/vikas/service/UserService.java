package in.vikas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import in.vikas.dao.UserDAO;

@Component
public class UserService {

	@Autowired
	@Qualifier("oracle") // which bean should be considered out of oracle nad mysql.
	private UserDAO dao;

	public UserService() {
		System.out.println("UserService::0-args Constructor..!");
	}

	// constructor injection.
	@Autowired
	public UserService(UserDAO dao) {
		System.out.println("UserService::Args- Constructor..!");
		this.dao = dao;
	}

	// setter injection.
	@Autowired
	public void setDao(UserDAO dao) {
		this.dao = dao;
		System.out.println("UserService::SetDAO()");
	}

	public void getUserName(Integer id) {
		String name = dao.findNameById(id);

		System.out.println(name);
	}

}
