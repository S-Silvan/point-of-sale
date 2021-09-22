package com.pos.customer.exception;

@SuppressWarnings("serial")
public class CartNotFoundException extends Exception{

	public  CartNotFoundException(String message) {
		super(message);
	}

}
