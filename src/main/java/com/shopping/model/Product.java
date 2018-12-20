package com.shopping.model;

public class Product {

	private String name;
	private double price;
	private boolean grocery;

	public Product(String name, double price, boolean grocery) {
		this.name = name;
		this.price = price;
		this.grocery = grocery;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public boolean isGrocery() {
		return grocery;
	}
	
	public boolean isNotGrocery() {
		return !grocery;
	}
}
