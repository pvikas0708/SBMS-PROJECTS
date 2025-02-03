package in.vikas.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vikas.entity.Address;
import in.vikas.entity.Employee;
import in.vikas.repo.AddRepo;
import in.vikas.repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private AddRepo addrRepo;
	
	public void saveEmp()
	{
		//one emp can have multiple addresses
		Address a1=new Address();
		 a1.setCity("PUNE");
		 a1.setState("MHA");
		 a1.setCountry("IND");
		 a1.setAddrType("Permanent");
		
		 Address a2=new Address();
		 a1.setCity("MUMBAI");
		 a1.setState("KA");
		 a1.setCountry("IND");
		 a1.setAddrType("Temp");
		 
		 Employee e=new Employee();
		 
		 e.setEmpName("Vikas");
		 e.setEmpSalary(80000.00);
		 
		 // Associating Emp with Adresses
		 a1.setEmp(e);
		 a2.setEmp(e);
		 
		 //Associate Addresses with emp object.
		 e.setAddr(Arrays.asList(a1,a2));
		 
		 //save Parent record
		 empRepo.save(e);
	}
	
	public void saveAddress()
	{
		//one emp can have multiple addresses
		Address a1=new Address();
		 a1.setCity("PUNE");
		 a1.setState("MHA");
		 a1.setCountry("IND");
		 a1.setAddrType("Permanent");
		
		 Address a2=new Address();
		 a1.setCity("MUMBAI");
		 a1.setState("KA");
		 a1.setCountry("IND");
		 a1.setAddrType("Temp");
		 
		 Employee e=new Employee();
		 
		 e.setEmpName("Ram");
		 e.setEmpSalary(80000.00);
		 
		 // Associating Emp with Adresses
		 a1.setEmp(e);
		 a2.setEmp(e);
		 
		 //Associate Addresses with emp object.
		 e.setAddr(Arrays.asList(a1,a2));
		 
		 //save Address records
		 empRepo.save(e);
		 addrRepo.save(a1);
		 addrRepo.save(a2);
	}
	
	public void getEmployee()
	{
		empRepo.findById(1);
	}
	
	public void getAddress()
	{
		addrRepo.findById(1);
	}
	
	public void deleteEmp()
	{
		empRepo.deleteById(1);
		
	}
	
}

