package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {

	List<Product> getAll();
	List<String> getByCategoryAndLesserPrice(String category,double price);
	Product getById(int productId);
}
