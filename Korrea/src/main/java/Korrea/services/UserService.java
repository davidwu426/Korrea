package Korrea.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import Korrea.dao.UserDAO;
import Korrea.model.Users;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired 
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = this.userDAO.findByUsername(username);
		if(user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Username not found with :" + username);
		}
	}
	
	public void registerUser(Users user) {
		user.setPassword(this.bcryptEncoder.encode(user.getPassword()));
		this.userDAO.save(user);
	}
	
	public boolean existsByUsername(String username) {
		return this.userDAO.existsByUsername(username);
	}
	
	public boolean existsByEmail(String email) {
		return this.userDAO.existsByEmail(email);
	}
		
}
