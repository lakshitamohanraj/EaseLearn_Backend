package com.lakshita.easelearn.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lakshita.easelearn.dto.SignupRequest;
import com.lakshita.easelearn.dto.UserDto;
import com.lakshita.easelearn.entity.User;
import com.lakshita.easelearn.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
  
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserDto createUser(SignupRequest signupRequest) {
		User user=new User();
		
		user.setEmail(signupRequest.getEmail());
		user.setName(signupRequest.getName());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		user.setRole();
	}
	
}
