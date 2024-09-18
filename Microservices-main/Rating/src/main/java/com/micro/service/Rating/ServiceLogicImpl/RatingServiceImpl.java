package com.Micro.Service.Rating.ServiceLogicImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Micro.Service.Rating.Entities.Rating;
import com.Micro.Service.Rating.Repositories.RatingRepository;
import com.Micro.Service.Rating.ServiceLogic.RatingService;

public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId() {
		// TODO Auto-generated method stub
		return ratingRepository;
	}

	@Override
	public List<Rating> getRatingByHotelId() {
		// TODO Auto-generated method stub
		return null;
	}

}
