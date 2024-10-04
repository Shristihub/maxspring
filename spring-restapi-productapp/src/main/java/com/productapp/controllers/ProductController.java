package com.productapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/C")
public class ProductController {

	private IProductService productService;
	
	public ProductController(IProductService productService) {
		super();
		this.productService = productService;
	}
	
//	http://localhost:8080/product-api/products
	@GetMapping("/products")
	List<Product> getAll(){
		return productService.getAll();
	}
	
//	http://localhost:8080/product-api/products/category/electronics/price/1200
	@GetMapping("/products/category/{category}/price/{price}")
	List<String> getByCategoryAndLesserPrice(
			@PathVariable("category")String category,@PathVariable("price")double price){
		return productService.getByCategoryAndLesserPrice(category, price);
	}
	
//	http://localhost:8080/product-api/products/id?productId=1
	@GetMapping("/products/id")
	Product getById(@RequestParam("productId") int productId) {
		return productService.getById(productId);
	}
}
