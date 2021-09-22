package com.pos.customer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pos.customer.entity.Customer;
import com.pos.customer.service.ProfileService;

@SpringBootTest
class ProfileTest {
	@Autowired
	private ProfileService profileService;

	@Test
	public void getCustomer() throws Exception {
		profileService.getCustomer(98787888l);
	}
	
	@Test
	public void updateCustomer() throws Exception {
		//profileService.updateCustomer();
	}
	

}
