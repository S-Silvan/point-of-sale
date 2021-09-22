package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.entity.Customer;
import com.pos.customer.service.ProfileService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@Log4j2
public class ProfileController {
	@Autowired
	private ProfileService customerService;

	@GetMapping("/customer/{phoneNo}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable("phoneNo") Long phoneNo) {
		log.info("ProfileController: View Customer Details......");
		try {
			log.trace("ProfileController: View Customer Details Success......");
			return customerService.getCustomer(phoneNo);
		} catch (Exception e) {
			log.error("ProfileController: View Customer Details Fails......");
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping("/update-customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customerDetails) {
		log.info("ProfileController: Edit Customer Details......");
		try {
			log.info("ProfileController: Edit Customer Details Success......");
			return customerService.updateCustomer(customerDetails);
		} catch (Exception e) {
			log.info("ProfileController: Edit Customer Details Fails......");
			e.printStackTrace();
		}
		return null;
	}
}