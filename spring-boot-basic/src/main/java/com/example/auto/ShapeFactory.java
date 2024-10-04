package com.example.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	// by type
	@Autowired
	@Qualifier("rectangle") // shape= new Rectangle
	IShape shape;
	
	//by name - bean name and instance variable name are same
	@Autowired
	IShape square; //shape = new Square();
	
    // by constructor
	IShape mshape;
    public ShapeFactory(@Qualifier("triangle") IShape mshape) {
		super();
		this.mshape = mshape;
	}



	public void printArea(int x, int y) {
	 System.out.println("Printing area");
	 shape.area(x, y);
	 square.area(12, 20);
	 mshape.area(20, 30);
	
	}

}
