package com.example.jauto;

import java.util.List;

public class VideoGames implements ISports {

	@Override
	public List<String> showGames() {
		return List.of("Xbox","playstation");
	}

}
