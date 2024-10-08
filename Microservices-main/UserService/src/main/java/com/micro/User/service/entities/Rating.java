package com.micro.User.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
	private String ratingId;
	private int UserId;
	private String hotelId;
	private int rating;
	private String remark;
}
