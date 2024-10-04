package com.example.jauto;

import java.util.List;

public class Indoor implements ISports {

	@Override
	public List<String> showGames() {
		return List.of("Chess","Carrom");
	}

}
