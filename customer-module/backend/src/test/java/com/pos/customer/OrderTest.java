package com.pos.customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.pos.customer.dto.OrderListDto;
import com.pos.customer.service.OrderService;

@SpringBootTest
public class OrderTest {
	@Autowired
	private OrderService orderService;
	
	@Test
	public void getOrders() throws Exception {
		List<OrderListDto> elist=new ArrayList<OrderListDto>();
		System.out.println(orderService.getOrders(8124098373l));
		assertNotNull(elist);
	}
	
	@Test
	public void  getOrder() throws Exception{
		
		System.out.println(orderService.getOrder(111234567l));
	
	}
}
