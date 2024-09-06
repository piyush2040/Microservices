package com.micro.User.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.User.service.entities.User;

public interface UserRepository extends JpaRepository<User,String>{

}
