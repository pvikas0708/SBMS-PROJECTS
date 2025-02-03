package in.vikas.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {
		System.out.println("UserDAOImpl::Constructor..!");
	}

	@Override
	public String findNameById(Integer id) {

		if (id == 100) {
			System.out.println("Raju");
		} else {
			System.out.println("Rani");
		}

		return null;
	}
}
