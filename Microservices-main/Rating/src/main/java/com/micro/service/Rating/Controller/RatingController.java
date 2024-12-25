package com.Micro.Service.Rating.Controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	private Logger logger = LoggerFactory.getLogger(RatingController.class);
	
	@PostMapping("/addRating")
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		System.out.println(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}
	@GetMapping("/getAllRating")
	public ResponseEntity<List<Rating>> getAllRating()
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ratingService.getRatings());
	}
	@GetMapping("/getRatingByUser/{userId}")
	public ResponseEntity<?> getRatingByUserId(@PathVariable("userId") UUID userId)
	{
		logger.debug("" + userId);
		if (userId == null) {
	        return ResponseEntity.internalServerError().body("Invalid userId");
	    }
		try {
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
		}
		catch(Exception ex)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	@GetMapping("/getRatingByHotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
	}
	
	
}
