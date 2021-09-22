package com.pos.customer.dto;

import java.util.List;

import com.pos.customer.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDto {
	private List<Product> productList;
}
