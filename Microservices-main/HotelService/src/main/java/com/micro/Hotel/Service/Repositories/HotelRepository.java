package com.micro.Hotel.Service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.Hotel.Service.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{
	Hotel findByEmail(String email);
}
