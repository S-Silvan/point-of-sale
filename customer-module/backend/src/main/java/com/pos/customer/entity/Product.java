package com.pos.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Long id;
	private String name;
	private String image;
	private String description;
	private Double mrp;
	private String brand;
	private Long stock;
	private Double tax;
	private Category category;
}
