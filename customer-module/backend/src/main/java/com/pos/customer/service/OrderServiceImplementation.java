package com.pos.customer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pos.customer.dto.OrderListDto;
import com.pos.customer.entity.Order;

@Service
public class OrderServiceImplementation implements OrderService {
	private RestTemplate restTemplate=new RestTemplate();
	
	@Override
	public ResponseEntity<OrderListDto> getOrders(Long customerId) throws Exception{
		return restTemplate.getForEntity(baseUrl+"get-orders/"+customerId, OrderListDto.class);
	}

	@Override
	public ResponseEntity<Order> getOrder(Long orderId) throws Exception {
		return restTemplate.getForEntity(baseUrl+"get-order/"+orderId, Order.class);
	}

}
