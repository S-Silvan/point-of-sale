package com.pos.customer.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Integer orderId;
	private LocalDate date;
	private Double totalPrice;
	private Float discount;
	private String modeOfPayment;
	private String status;
	private String tracking;
	private Address address;
	private Customer customer;
	private List<OrderItem> orders;
}
