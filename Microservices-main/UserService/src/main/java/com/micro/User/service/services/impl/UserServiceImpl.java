package com.micro.User.service.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.micro.User.service.entities.ResponseMessage;
import com.micro.User.service.entities.User;
import com.micro.User.service.repositories.UserRepository;
import com.micro.User.service.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<?> saveUser(User user) {
	    try {
	        // Check if the user is null
	        if (user == null) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body(new ResponseMessage("400", "User data is missing."));
	        }

	        // Check if the email is provided
	        if (user.getEmail() == null || user.getEmail().isEmpty()) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body(new ResponseMessage("400", "Email is required."));
	        }

	        // Check if user already exists
	        Optional<User> userExist = userRepository.findByEmail(user.getEmail());
	        System.out.println("1");
	        // If the user is found, return a conflict status
	        if (userExist.isPresent()) {
	            return ResponseEntity.status(HttpStatus.CONFLICT)
	                    .body(new ResponseMessage("409", "User already exists."));
	        }
	        System.out.println("2");
	        // Save the new user
	        userRepository.save(user);
	        
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(user);

	    } catch (Exception e) {
	        // Handle exceptions and return a generic bad gateway status
	        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
	                .body(new ResponseMessage("502", e.getMessage()));
	    }
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
		
		Optional<User> user = userRepository.findByEmail(userEmail);
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
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseMessage("400", "User data is missing."));
		}
		Optional<User> UserExist = userRepository.findByEmail(user.getEmail());
		if(UserExist.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseMessage("404","User doesnot exists."));
		}
		user.setUserId(UserExist.get().getUserId());
		userRepository.save(user);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(user);
	}

	@Override
	@Transactional
	public ResponseEntity<?> deleteUser(String userEmail) {
		try {
		System.out.println(userEmail);
		Optional<User> UserExist = userRepository.findByEmail(userEmail);
		
		if(UserExist.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseMessage("404","User doesnot exists."));
		}
		
		userRepository.deleteByEmail(userEmail);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(new ResponseMessage("206","successfully deleted"));
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY)
					.body(new ResponseMessage("206",e.getMessage()));
		}
	}

}
