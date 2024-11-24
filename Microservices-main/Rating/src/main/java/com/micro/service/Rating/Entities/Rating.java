package com.Micro.Service.Rating.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("user_ratings")
public class Rating {
	@Id
	private String Id;
	private String UserId;
	private String hotelId;
	private int rating;
	private String remark;
}
