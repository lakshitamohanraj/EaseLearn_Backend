package com.lakshita.easelearn.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lakshita.easelearn.config.JwtTokenProvider;
import com.lakshita.easelearn.entity.Student;
import com.lakshita.easelearn.entity.Teacher;
import com.lakshita.easelearn.entity.User;
import com.lakshita.easelearn.enums.UserRole;
import com.lakshita.easelearn.exception.UserException;
import com.lakshita.easelearn.repository.TeacherRepository;
import com.lakshita.easelearn.repository.StudentRepository;
import com.lakshita.easelearn.repository.UserRepository;
import com.lakshita.easelearn.request.LoginRequest;
import com.lakshita.easelearn.response.AuthResponse;
import com.lakshita.easelearn.services.CustomUserDetails;


@RestController
@RequestMapping("/auth")

public class AuthController {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	private CustomUserDetails customUserDetails;
	private TeacherRepository teacherRepository;
	private StudentRepository studentRepository;

	
	public AuthController(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtTokenProvider jwtTokenProvider,CustomUserDetails customUserDetails,
			TeacherRepository teacherRepository,StudentRepository studentRepository) {
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
		this.jwtTokenProvider=jwtTokenProvider;
		this.customUserDetails=customUserDetails;
		this.teacherRepository = teacherRepository;
		this.studentRepository = studentRepository;

	}
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler( @RequestBody User user) throws UserException{
		
		  	String email = user.getEmail();
	        String password = user.getPassword();
	        String name = user.getName();
	       String userRole = user.getRole(); // got user role field
	        
	        User isEmailExist=userRepository.findByEmail(email);

	        // Check if user with the given email already exists
	        if (isEmailExist!=null) {
	        // System.out.println("--------- exist "+isEmailExist).getEmail());
	        	
	            throw new UserException("Email Is Already Used With Another Account");
	        }

	        // Create new user
			User createdUser= new User();
			createdUser.setEmail(email);
			createdUser.setName(name);
	        createdUser.setPassword(passwordEncoder.encode(password));
	        createdUser.setRole(userRole); // saved user role 
	        
	        
	        User savedUser= userRepository.save(createdUser);
	        Long userId = savedUser.getId();
	        
	        // Save user in Teacher or Student table
	        if ("TEACHER".equalsIgnoreCase(userRole)) {
	            Teacher teacher = new Teacher();
	            teacher.setName(name);
	            teacher.setUser(savedUser);
	            teacherRepository.save(teacher);
	        } else if ("STUDENT".equalsIgnoreCase(userRole)) {
	            Student student = new Student();
	            student.setName(name);
	            student.setUser(savedUser);
	            student.setDate_of_join(LocalDate.now());
	            studentRepository.save(student);
	        }

	        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        
	        String token = jwtTokenProvider.generateToken(authentication);

	        AuthResponse authResponse= new AuthResponse(token,true,userRole,userId); // sending userId 
			
	        return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {
		
        String username = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        System.out.println(username +" ----- "+password);
        
        Authentication authentication = authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        User user = userRepository.findByEmail(username);
        
        
        if (user == null) {
            throw new BadCredentialsException("User not found");
        }
        
        System.out.println("Role-----"+user.getRole()+" ------"+user.getEmail());
        Long userId = user.getId();
        
        // Extract Role from User Entity
        String role = user.getRole(); 
        
        String token = jwtTokenProvider.generateToken(authentication);
        AuthResponse authResponse= new AuthResponse();
		
		authResponse.setStatus(true);
		authResponse.setJwt(token);
		authResponse.setRole(role);
		authResponse.setUserId(userId);
		
		System.out.println("Role : "+role);
		
        return new ResponseEntity<AuthResponse>(authResponse,HttpStatus.OK); //sending the userID too
    }
	
	private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customUserDetails.loadUserByUsername(username);
        
        System.out.println("sign in userDetails - "+userDetails);
        
        if (userDetails == null) {
        	System.out.println("sign in userDetails - null " + userDetails);
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
        	System.out.println("sign in userDetails - password not match " + userDetails);
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
