package com.example.jauto;

import java.util.List;

public class Outdoor implements ISports {

	@Override
	public List<String> showGames() {
		return List.of("Cricket","Football");
	}

}
