package com.lakshita.easelearn.services;

import com.lakshita.easelearn.entity.User;
import com.lakshita.easelearn.exception.UserException;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;

}