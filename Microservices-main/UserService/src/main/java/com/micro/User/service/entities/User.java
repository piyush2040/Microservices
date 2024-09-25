package com.micro.User.service.entities;
import java.util.List;

import jakarta.persistence.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@Id
	@Column(name = "ID")
	private String Id;
	@Column(name = "NAME", length = 15)
	private String name;
	@Column(name = "EMAIL",unique = true)
	private String email;
	@Column(name = "ABOUT")
	private String about;
	@Column(name = "ROLE",nullable = false)
	private String role;
	@Transient
	private List<Rating> ratings;
}
