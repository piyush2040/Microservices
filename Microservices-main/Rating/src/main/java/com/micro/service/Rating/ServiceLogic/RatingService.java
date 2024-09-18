package com.Micro.Service.Rating.ServiceLogic;

import java.util.List;

import com.Micro.Service.Rating.Entities.Rating;

public interface RatingService {
	Rating create(Rating rating);
	List<Rating> getRatings();
	List<Rating> getRatingByUserId();
	List<Rating> getRatingByHotelId();
}
