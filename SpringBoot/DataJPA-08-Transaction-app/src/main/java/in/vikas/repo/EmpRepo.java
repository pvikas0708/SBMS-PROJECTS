package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer> {

}
