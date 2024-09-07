package com.micro.User.service.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.micro.User.service.entities.ResponseMessage;
import com.micro.User.service.entities.User;
import com.micro.User.service.repositories.UserRepository;
import com.micro.User.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<?> saveUser(User user) {
		if(user == null)
		{
			return null;
		}
		User UserExist = userRepository.findByEmailUser(user.getEmail()).get();
		if(UserExist != null)
		{
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
					.body(new ResponseMessage("208","User already exists."));
		}
		userRepository.save(user);
		
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
				.body(user);
	}

	@Override
	public ResponseEntity<List<User>> getAllUser() {
		// TODO Auto-generated method stub
		List<User> allUsers = userRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(allUsers);
	}

	@Override
	public ResponseEntity<?> getUser(String userEmail) {
		// TODO Auto-generated method stub
		
		Optional<User> user = userRepository.findByEmailUser(userEmail);
		if(user.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseMessage("204", "User not exists"));
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user.get());
	}

	@Override
	public ResponseEntity<?> updateUser(User user) {
		// TODO Auto-generated method stub
		if(user == null)
		{
			return null;
		}
		Optional<User> UserExist = userRepository.findByEmailUser(user.getEmail());
		if(UserExist.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseMessage("404","User doesnot exists."));
		}
		userRepository.save(user);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(user);
	}

	@Override
	public ResponseEntity<?> deleteUser(String userEmail) {
		Optional<User> UserExist = userRepository.findByEmailUser(userEmail);
		if(UserExist.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseMessage("404","User doesnot exists."));
		}
		
		Boolean isDeleted = userRepository.deleteByEmailUser(userEmail);
		if(!isDeleted)
		{
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY)
					.body(new ResponseMessage("206","Something went wrong"));
		}
		return null;
	}

}
