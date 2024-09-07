package com.micro.User.service.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.micro.User.service.entities.User;

public interface UserService {

	
	ResponseEntity<?> saveUser(User user);
	
	ResponseEntity<List<User>> getAllUser();
	
	ResponseEntity<?> getUser(String userEmail);
	
	ResponseEntity<?> updateUser(User user);
	
	ResponseEntity<?> deleteUser(String userEmail);
}
