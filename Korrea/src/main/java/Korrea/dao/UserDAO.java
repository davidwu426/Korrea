package Korrea.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Korrea.model.Users;

@Repository
public interface UserDAO extends JpaRepository<Users,Integer>{
	
	public Users findByUsername(String username);
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
	
}
