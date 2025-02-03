package in.vikas.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("oracle")
@Primary
public class OracleUserDAOImpl implements UserDAO {

	public OracleUserDAOImpl() {
		System.out.println("OracleUserDAOImpl::Constructor..!");
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
