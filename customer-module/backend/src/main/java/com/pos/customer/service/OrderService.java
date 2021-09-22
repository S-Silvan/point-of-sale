package com.pos.customer.service;

import org.springframework.http.ResponseEntity;

import com.pos.customer.dto.OrderListDto;
import com.pos.customer.entity.Order;

public interface OrderService {
	String baseUrl="https://admin-pos.herokuapp.com/api/";
	ResponseEntity<OrderListDto> getOrders(Long customerId) throws Exception;
	ResponseEntity<Order> getOrder(Long orderId) throws Exception ;
}
