package in.vikas.dao;

import org.springframework.stereotype.Component;

@Component("mysql")
public class MysqlUserDAOImpl implements UserDAO {

	public MysqlUserDAOImpl() {
		System.out.println("MysqlUserDAOImpl::Constructor..!");
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
