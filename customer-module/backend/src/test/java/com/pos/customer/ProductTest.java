package com.pos.customer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pos.customer.dto.ProductListDto;
import com.pos.customer.service.OrderService;
import com.pos.customer.service.ProductService;

@SpringBootTest
class ProductTest {
	@Autowired
	private ProductService productService;

	@Test
	public void getProducts() throws Exception {
		List<ProductListDto> list=new ArrayList<ProductListDto>();
		productService.getProducts();
		assertNotNull(list);
	}
	
	@Test
	public void getCategoryProducts() throws Exception {
		List<ProductListDto> list=new ArrayList<ProductListDto>();
		productService.getCategoryProducts(12);
		assertNotNull(list);
	}
	
	@Test
	public void getProduct() throws Exception {
		List<ProductListDto> list=new ArrayList<ProductListDto>();
		productService.getProduct(21);
		assertNotNull(list);
	}
	
	

}
