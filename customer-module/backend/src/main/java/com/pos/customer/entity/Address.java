package com.pos.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private Long id;
	private String addressLine;
	private String city;
	private Long pinCode;
	private State state;
	private Customer customer;
}
