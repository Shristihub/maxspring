package com.example.auto;

import org.springframework.stereotype.Component;

@Component
public class Triangle  implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("Tri "+(0.5*x*y));
	}

}
