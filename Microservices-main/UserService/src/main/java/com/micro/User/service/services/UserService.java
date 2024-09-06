package com.micro.User.service.services;

import java.util.List;

import com.micro.User.service.entities.User;

public interface UserService {

	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
	User updateUser(User user);
	
	Boolean deleteUser(String userId);
}
