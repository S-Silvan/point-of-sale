package com.pos.customer.entity;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Long phoneNumber;
	private String name;
	private String email;
	private String password;
	private Set<Address> addresses;
}
