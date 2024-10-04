package com.example.jauto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SportsConfig {

	@Bean
	Indoor indoor() {
		return new Indoor();
	}
	@Bean
	@Primary
	Outdoor outdoor() {
		return new Outdoor();
	}
	@Bean
	VideoGames vgames() {
		return new VideoGames();
	}
	@Bean
	Player player() {
		return new Player();
	}
}
