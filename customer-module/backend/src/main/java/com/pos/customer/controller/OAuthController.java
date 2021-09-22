package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Customer;
import com.pos.customer.entity.OAuth;
import com.pos.customer.service.OAuthService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@Log4j2
public class OAuthController {

	@Autowired
	private OAuthService oauthService;

	@PostMapping("/authenticate")
	public ResponseEntity<Customer> createCustomerLogin(@RequestBody OAuth oauth) {
		log.info("OAuthController: Customer Login authentication.......");
		try {
			log.trace("OAuthController: Customer Login authentication Success");
			return oauthService.login(oauth);
		} catch (Exception e) {
			log.error("OAuthController: Customer Login authentication Fails");
			e.printStackTrace();
		}
		
		return null;
	}
}
