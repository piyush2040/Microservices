package com.micro.Hotel.Service.ControllerLogic;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.micro.Hotel.Service.entities.Hotel;

public interface HotelService {
	public Hotel Create(Hotel hotel);
	public List<Hotel> getAllHotels();
	public Hotel getHotelByEmail(String Email);
	public Hotel updateHotel(Hotel hotel);
	public ResponseEntity<?> deleteHotel(String email);
	
	
}
