package com.Micro.Service.Rating.ServiceLogicImpl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Micro.Service.Rating.Entities.Rating;
import com.Micro.Service.Rating.Repositories.RatingRepository;
import com.Micro.Service.Rating.ServiceLogic.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	private Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);
	
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		String RatingId = UUID.randomUUID().toString();
		rating.setId(RatingId);
		System.out.println(rating);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(UUID userId) {
		// TODO Auto-generated method stub
		List<Rating> ratings = null;
		try {
			String userIdString = userId.toString();
			 ratings = ratingRepository.findByUserId(userIdString);
		}
		catch(Exception ex)
		{
			logger.debug(ex.getMessage());
		}
		
		return ratings;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}

}
