package com.productapp.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private String productName;
	private Integer productId;
	private String brand;
	private String category; // the value to be taken from enum
	private double price;
	private LocalDate expiryDate;
	
	
	
}
