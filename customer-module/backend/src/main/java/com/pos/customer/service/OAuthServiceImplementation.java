package com.pos.customer.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pos.customer.entity.Customer;
import com.pos.customer.entity.OAuth;

@Service
public class OAuthServiceImplementation implements OAuthService {
	private RestTemplate restTemplate=new RestTemplate();
	public ResponseEntity<Customer> login(OAuth oauth) throws Exception{
		ResponseEntity<Customer> re=restTemplate.getForEntity(baseUrl+"customer/"+oauth.getUserId(), Customer.class);
		Customer c=re.getBody();
		if(c.getPassword()==oauth.getPassword())
			return restTemplate.getForEntity(baseUrl+"customer/"+oauth.getUserId(), Customer.class);
		return restTemplate.getForEntity(baseUrl+"customer/"+oauth.getUserId(), Customer.class);
	}
}
