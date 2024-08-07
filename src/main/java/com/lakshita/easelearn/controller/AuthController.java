package com.lakshita.easelearn.controller;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lakshita.easelearn.dto.AuthenticationRequest;
import com.lakshita.easelearn.entity.User;
import com.lakshita.easelearn.repository.UserRepository;
import com.lakshita.easelearn.utils.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	private UserDetailsService userDetailsService;
	private UserRepository userRepository;
	
	
	private  JwtUtil jwtUtil;
	
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization";
	
	
	@PostMapping("/authenticate")
	public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
			HttpServletResponse response) throws IOException,JSONException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
			
		}
		catch(BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect username or password");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		Optional<User>optionalUser=userRepository.findFirstByEmail(userDetails.getUsername());
		
		final String jwt=jwtUtil.generateToken(userDetails.getUsername());
		
		if(optionalUser.isPresent()) {
			response.getWriter().write(new JSONObject()
					.put("userId",optionalUser.get().getId())
					.put("role",optionalUser.get().getRole())
					.toString());
			
			response.addHeader(HEADER_STRING,TOKEN_PREFIX+jwt);
		}
		
	}
  
}
