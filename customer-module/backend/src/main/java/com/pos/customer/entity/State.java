package com.pos.customer.entity;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {
	private Long id;
	private String name;
	private Country country;
	private Set<Address> address;
}
