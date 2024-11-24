package com.micro.User.service.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
