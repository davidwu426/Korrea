package Korrea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Korrea.config.JwtTokenUtil;
import Korrea.model.JwtRequest;
import Korrea.model.JwtResponse;
import Korrea.services.UserService;

import Korrea.model.Users;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody Users user){
		System.out.println(user);
		if(this.userService.existsByUsername(user.getUsername())){
			return ResponseEntity.ok(HttpStatus.CONFLICT);
		}else if(this.userService.existsByEmail(user.getEmail())) {
			return ResponseEntity.ok(HttpStatus.CONFLICT);
		}else {
			this.userService.registerUser(user);
			return ResponseEntity.ok(HttpStatus.CREATED);
		}
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails.getUsername());
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
		
}
