package com.micro.Hotel.Service.ControllerLogicImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.micro.Hotel.Service.entities.Hotel;
import com.micro.Hotel.Service.ControllerLogic.HotelService;
import com.micro.Hotel.Service.Repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel Create(Hotel hotel) {
		
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		hotelRepository.save(hotel);
		
		return hotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		List<Hotel> hotels =  hotelRepository.findAll();
		return hotels;
	}

	@Override
	public Hotel getHotelByEmail(String email) {
		Hotel hotel = hotelRepository.findByEmail(email);
		return hotel;
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		Hotel oldhotel = hotelRepository.findByEmail(hotel.getEmail());
		hotel.setId(oldhotel.getId());
		hotelRepository.save(hotel);
		return hotel;
	}

	@Override
	public ResponseEntity<?> deleteHotel(String email) {
		
		Hotel hotel = hotelRepository.findByEmail(email);
		hotelRepository.delete(hotel);
		
		return null;
	}

	
	
}
