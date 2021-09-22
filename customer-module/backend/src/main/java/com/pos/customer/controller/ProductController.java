package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.dto.ProductListDto;
import com.pos.customer.entity.Product;
import com.pos.customer.service.ProductService;

import lombok.extern.log4j.Log4j2;



@RestController
@RequestMapping("/customer")
@CrossOrigin
@Log4j2 
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<ProductListDto> getProducts() {
		log.info("ProductController: Get all products......");
		try {
			log.trace("ProductController: Get all products Success......");
			return productService.getProducts();
		} catch (Exception e) {
			log.error("ProductController: Get all products Fails......");
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/products/category/{category-id}")
	public ResponseEntity<ProductListDto> getCategoryProducts(@PathVariable("category-id")Integer categoryId) {
		log.info("ProductController: Get all products according to Product categories......");
		try {
			log.trace("ProductController: Get all products according to Product categories Success......");
			return productService.getCategoryProducts(categoryId);
		} catch (Exception e) {
			log.error("ProductController: Get all products according to Product categories Fails......");
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/product/{product-id}")
	public ResponseEntity<Product> getProduct(@PathVariable("product-id")Integer productId) {
		log.info("ProductController: Get particular product......");
		try {
			log.trace("ProductController: Get particular product Success......");
			return productService.getProduct(productId);
		} catch (Exception e) {
			log.error("ProductController: Get particular product Fails......");
			e.printStackTrace();
		}
		return null;
	}
}
