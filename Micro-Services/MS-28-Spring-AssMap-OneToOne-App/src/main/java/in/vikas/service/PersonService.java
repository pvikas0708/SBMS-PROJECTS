package in.vikas.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vikas.entity.Passport;
import in.vikas.entity.Person;
import in.vikas.repo.PassportRepo;
import in.vikas.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;
	
	@Autowired	
	private PassportRepo passportRepo;
	
	public void savePerson()
	{
		Person person=new Person();
		
		person.setPersonName("Vikas");
		person.setPersonGender("Male");
		person.setPersonDob(LocalDate.now().minusYears(20));
		
		
		Passport passport=new Passport();
		
		passport.setPassportNum("BHNPP1773N");
		passport.setIssuedDate(LocalDate.now());
		passport.setExpDate(LocalDate.now().plusYears(10));
		
		
		//Association
		person.setPassport(passport);
		passport.setPerson(person);
		
		//saving only parent(parent) record
		personRepo.save(person);
	}

	public void getPerson()
	{
		personRepo.findById(1);
		
	}
	
	public void getPasspoert()
	{
		passportRepo.findById(1);
		
	}
	public void deletePerson()
	{
		personRepo.deleteById(1);
	}
}
