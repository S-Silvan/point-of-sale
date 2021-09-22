package com.pos.customer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pos.customer.dto.ProductListDto;
import com.pos.customer.entity.Product;

@Service
public class ProductServiceImplementation implements ProductService {
	private RestTemplate restTemplate=new RestTemplate();

	@Override
	public ResponseEntity<ProductListDto> getProducts() throws Exception {
		return restTemplate.getForEntity(baseUrl+"product", ProductListDto.class);
	}

	@Override
	public ResponseEntity<ProductListDto> getCategoryProducts(Integer categoryId) throws Exception {
		return restTemplate.getForEntity(baseUrl+"products/"+categoryId, ProductListDto.class);
	}

	@Override
	public ResponseEntity<Product> getProduct(Integer productId) throws Exception {
		return restTemplate.getForEntity(baseUrl+"product/"+productId, Product.class);
	}

}
