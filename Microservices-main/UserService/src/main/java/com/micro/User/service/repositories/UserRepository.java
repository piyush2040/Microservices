package com.micro.User.service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.micro.User.service.entities.User;

public interface UserRepository extends JpaRepository<User,String>{
	public Optional<User> findByEmail(String email);
	
	public void deleteByEmail(String email);
}
