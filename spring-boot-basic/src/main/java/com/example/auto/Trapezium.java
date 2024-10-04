package com.example.auto;

import org.springframework.stereotype.Component;

@Component("rectangle")
public class Trapezium implements IShape{

	@Override
	public void area(int x, int y) {
		System.out.println("Trap");
	}

}
