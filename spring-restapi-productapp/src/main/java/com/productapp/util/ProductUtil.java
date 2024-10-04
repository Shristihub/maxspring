package com.productapp.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.productapp.model.Category;
import com.productapp.model.Product;

@Component
public class ProductUtil {
	
	public List<Product> showProducts() {
		String electronics = Category.ELECTRONICS.name();
		String gadgets = Category.GADGETS.name();
		String home = Category.HOMEAPPLIANCES.name();
		String mobiles = Category.MOBILES.name();
		String music = Category.MUSICSYSTEM.name();
		
		return Arrays.asList(
				new Product("Mobile",1,"Samsung",mobiles,20000,LocalDate.of(2024, 12, 22)),
				new Product("Mobile",2,"OnePlus",mobiles,40000,LocalDate.of(2025, 2, 18)),
				new Product("HeadPhones",3,"Bose",music,120000,LocalDate.of(2024, 12, 22)),
				new Product("Television",4,"Samsung",electronics,220000,LocalDate.of(2025, 12, 22)),
				new Product("earphones",5,"OnePlus",electronics,3000,LocalDate.of(2024, 12, 22)),
				new Product("Television",6,"Samsung",home,220000,LocalDate.of(2025, 12, 22)),
				new Product("earphones",7,"OnePlus",electronics,3000,LocalDate.of(2024, 12, 22))
		
		);
	}

}
