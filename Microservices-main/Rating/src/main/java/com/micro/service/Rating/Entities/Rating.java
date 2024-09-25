package com.Micro.Service.Rating.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("user_ratings")
public class Rating {
	@Id
	private String Id;
	private int UserId;
	private String hotelId;
	private int rating;
	private String remark;
}
