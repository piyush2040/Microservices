package com.Micro.Service.Rating.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Micro.Service.Rating.Entities.Rating;

public interface RatingRepository extends MongoRepository<Rating,String>{

}
