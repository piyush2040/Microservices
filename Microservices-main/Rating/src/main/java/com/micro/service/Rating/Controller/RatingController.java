package com.Micro.Service.Rating.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Micro.Service.Rating.Entities.Rating;
import com.Micro.Service.Rating.ServiceLogic.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/addRating")
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}
	@GetMapping("/getAllRating")
	public ResponseEntity<List<Rating>> getAllRating()
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
	}
	@GetMapping("/getRatingByUser/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable int userId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
	}
	@GetMapping("/getRatingByHotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
	}
	
	
}
