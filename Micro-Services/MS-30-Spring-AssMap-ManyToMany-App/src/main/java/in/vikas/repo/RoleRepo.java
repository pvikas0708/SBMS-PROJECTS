package in.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vikas.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
