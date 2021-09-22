package com.pos.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
	private Integer id;
	private Integer quantity;
	private Double price;
	private Order order;
	private Product product;
}
