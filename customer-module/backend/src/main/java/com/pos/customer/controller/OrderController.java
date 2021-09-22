package com.pos.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.customer.dto.OrderListDto;
import com.pos.customer.entity.Order;
import com.pos.customer.service.OrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@Log4j2
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders/{customer-id}")
	public ResponseEntity<OrderListDto> getOrders(@PathVariable("customer-id")Long customerId){
		log.info("OrderController: Customer all Orders retrieval.......");
		try {
			log.trace("OrderController: Customer all Orders retrieval Success.......");
			return orderService.getOrders(customerId);
		} catch (Exception e) {	
			log.error("OrderController: Customer all Orders retrieval Fails.......");
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/order/{order-id}")
	public ResponseEntity<Order> getOrder(@PathVariable("order-id")Long orderId){
		log.info("OrderController: Customer particular Order retrieval.......");
		try {
			log.trace("OrderController: Customer particular Order retrieval Success.......");
			return orderService.getOrder(orderId);
		} catch (Exception e) {	
			log.info("OrderController: Customer particular Order retrieval Fails.......");
			e.printStackTrace();
		}
		return null;
	}
}
