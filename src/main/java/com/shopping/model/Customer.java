package com.shopping.model;

import java.time.LocalDate;

public class Customer {

	private String name;
	private CustomerType customerType;
	private LocalDate firstPurchaseDate;

	public Customer(String name, CustomerType customerType, String date) {
		this.name = name;
		this.customerType = customerType;
		this.firstPurchaseDate = LocalDate.parse(date);
	}

	public String getName() {
		return name;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}
	
	public LocalDate getFirstPurchaseDate(){
		return firstPurchaseDate;
	}

}
