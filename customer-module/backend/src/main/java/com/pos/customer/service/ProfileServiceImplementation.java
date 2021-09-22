package com.pos.customer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pos.customer.entity.Customer;

@Service
public class ProfileServiceImplementation implements ProfileService {
	private RestTemplate restTemplate=new RestTemplate();
	
	@Override
	public ResponseEntity<Customer> getCustomer(Long phoneNo) throws Exception {
		return restTemplate.getForEntity(baseUrl+"customer/"+phoneNo, Customer.class);
	}

	@Override
	public ResponseEntity<String> updateCustomer(Customer customerDetails) throws Exception {
		return restTemplate.getForEntity(baseUrl+"update-customer", String.class);
	}
}