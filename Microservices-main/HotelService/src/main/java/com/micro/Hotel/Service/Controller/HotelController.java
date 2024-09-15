package com.micro.Hotel.Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.Hotel.Service.ControllerLogic.HotelService;
import com.micro.Hotel.Service.entities.Hotel;

@RestController
@RequestMapping("/Hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/addHotel")
	public Hotel CreateHotel(Hotel hotel)
	{
		return hotelService.Create(hotel);
	}
	
	@GetMapping("/getHotelByEmail")
	public Hotel GetHotelByEmail(String email)
	{
		return hotelService.getHotelByEmail(email);
	}
	
	@GetMapping("/GetAllHotels")
	public List<Hotel> GetAllHotel()
	{
		return hotelService.getAllHotels();
	}
	
	@PutMapping("/updateHotel")
	public Hotel updateHotel(Hotel hotel)
	{
		return hotelService.updateHotel(hotel);
	}
	
	@DeleteMapping("/deleteHotel")
	public ResponseEntity<?> deleteHotel(String email)
	{
		return hotelService.deleteHotel(email);
	}
	
	
	
	
}
