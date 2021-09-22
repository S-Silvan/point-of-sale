package com.pos.customer.service;

import org.springframework.http.ResponseEntity;

import com.pos.customer.dto.ProductListDto;
import com.pos.customer.entity.Product;

public interface ProductService {
	String baseUrl="https://admin-pos.herokuapp.com/api/";
	
	ResponseEntity<ProductListDto> getProducts() throws Exception;
	ResponseEntity<ProductListDto> getCategoryProducts(Integer categoryId) throws Exception;
	ResponseEntity<Product> getProduct(Integer productId) throws Exception;
}
