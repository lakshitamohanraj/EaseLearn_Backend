package com.lakshita.easelearn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lakshita.easelearn.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
   Optional<User> findFirstByEmail(String email);
   
}
