package com.example.auto;

import org.springframework.stereotype.Component;

@Component
public class Square  implements IShape {

	@Override
	public void area(int x, int y) {
		System.out.println("Sq "+(x*x));
	}

}
