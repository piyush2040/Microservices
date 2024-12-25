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
@Document("user_ratings") // Ensure this matches your MongoDB collection name
public class Rating {
    @Id
    private String id;      // MongoDB's default "_id" field
    private String userId;  // Ensure case matches repository method
    private String hotelId;
    private int rating;
    private String remark;
}
