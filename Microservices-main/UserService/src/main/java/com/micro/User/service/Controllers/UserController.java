package com.micro.User.service.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.micro.User.service.entities.User;
import com.micro.User.service.services.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		System.out.println(user);
		return userService.saveUser(user);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/getUserById/{userEmail}")
	public ResponseEntity<?> getUser(@PathVariable String userEmail) {
		return userService.getUser(userEmail);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{userEmail}")
	public ResponseEntity<?> deleteUser(@PathVariable String userEmail) {
		return userService.deleteUser(userEmail);
	}
	
}
