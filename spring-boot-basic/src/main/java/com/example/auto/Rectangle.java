package com.example.auto;

import org.springframework.stereotype.Component;

//@Component
public class Rectangle  implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("Rect "+(x*y));
	}

}
