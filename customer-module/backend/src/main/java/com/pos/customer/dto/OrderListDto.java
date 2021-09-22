package com.pos.customer.dto;

import java.util.List;

import com.pos.customer.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListDto {
	private List<Order> orderList;
}
