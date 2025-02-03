package in.vikas.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

	@Override
	public boolean saveUser(String uname, String email, String pwd) {

		// db logic

		System.out.println("Record inserted in DB..!");
		return true;
	}

}
