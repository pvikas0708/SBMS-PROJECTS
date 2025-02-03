package in.vikas.srvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vikas.entity.Address;
import in.vikas.entity.Emp;
import in.vikas.repo.AddressRepo;
import in.vikas.repo.EmpRepo;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmpRepo empRepo;

	private AddressRepo addRepo;

	public EmployeeService(EmpRepo empRepo, AddressRepo addRepo) {
		this.empRepo = empRepo;
		this.addRepo = addRepo;
	}

	@Transactional(rollbackOn = Exception.class)
	public void saveData() {
		Emp emp = new Emp();
		emp.setEname("Vikas");
		emp.setEsal(25000.00);

		Emp saveedEntity = empRepo.save(emp); // employee daved

		// int i=10/0; it will create java.lang.ArithmeticException and none record will
		// be updated in tabble in order to achieve the automicity in this situation we
		// have to give @transactional annotation

		int i=10/0;
		
		Address addr = new Address();

		addr.setCity("PUNE");
		addr.setState("MHA");
		addr.setCountry("IND");
		addr.setType("permanent");

		addr.setEmpId(saveedEntity.getEid()); // to get emp id

		addRepo.save(addr); // address saved
	}

}
