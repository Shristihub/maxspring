package com.example.jauto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Player {

	@Autowired
	@Qualifier("vgames")
	ISports sports;
	
	public List<String> gamesPlayed() {
		List<String> mygames = sports.showGames();
		return mygames;
	}
}
