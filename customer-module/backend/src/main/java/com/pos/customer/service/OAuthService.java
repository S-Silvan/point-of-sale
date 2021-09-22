package com.pos.customer.service;

import org.springframework.http.ResponseEntity;

import com.pos.customer.entity.Customer;
import com.pos.customer.entity.OAuth;

public interface OAuthService {
	String baseUrl="https://admin-pos.herokuapp.com/api/";
	ResponseEntity<Customer> login(OAuth oauth) throws Exception;
}
