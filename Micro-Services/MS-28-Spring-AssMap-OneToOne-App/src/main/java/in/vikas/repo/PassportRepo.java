package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.Passport;

public interface PassportRepo extends JpaRepository<Passport, Integer>{

}
