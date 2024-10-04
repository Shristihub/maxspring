package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.util.ProductUtil;
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductUtil productUtil;

	@Override
	public List<Product> getAll() {
		return productUtil.showProducts();
	}

	@Override
	public List<String> getByCategoryAndLesserPrice(String category, double price) {
		return productUtil.showProducts()
				.stream()
				.filter(product-> product.getCategory().equals(category)&&product.getPrice()<price)
				.map(product->product.getProductName())
				.toList();
	}

	@Override
	public Product getById(int productId) {
		return productUtil.showProducts()
				.stream()
				.filter(product-> product.getProductId()==productId)
				.findFirst()
				.orElse(null);
	}

}
