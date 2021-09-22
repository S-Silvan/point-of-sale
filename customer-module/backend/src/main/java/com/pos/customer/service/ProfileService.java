package com.pos.customer.service;

import org.springframework.http.ResponseEntity;

import com.pos.customer.entity.Customer;

public interface ProfileService {
	String baseUrl="https://admin-pos.herokuapp.com/api/";
	ResponseEntity<Customer> getCustomer(Long phoneNo) throws Exception;
	ResponseEntity<String> updateCustomer(Customer customerDetails) throws Exception;
}
