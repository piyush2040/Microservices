package com.Micro.Service.Rating.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Micro.Service.Rating.Entities.Rating;

public interface RatingRepository extends MongoRepository<Rating,String>{

	List<Rating> findByUserId(int userId);
	List<Rating> findByHotelId(String hotelId);
}
