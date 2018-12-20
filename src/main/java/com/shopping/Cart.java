package com.shopping;

import java.util.ArrayList;
import java.util.List;

import com.shopping.model.Customer;
import com.shopping.model.Product;
import com.shopping.strategy.AffliateDiscount;
import com.shopping.strategy.CustomerDiscount;
import com.shopping.strategy.DiscountStrategy;
import com.shopping.strategy.EmployeeDiscount;

public class Cart {

	private List<Product> items = new ArrayList<>();

	private Customer customer;
	// discount Strategy will depend on Customer
	private DiscountStrategy discountStrategy;

	private double total;

	private double discount;

	private double payableAmount;

	public Cart(Customer customer) {
		this.customer = customer;
		switch (this.customer.getCustomerType()) {
		case EMPLOYEE:
			this.discountStrategy = new EmployeeDiscount();
			break;
		case AFFLIATE:
			this.discountStrategy = new AffliateDiscount();
			break;
		default:
			this.discountStrategy = new CustomerDiscount();
			break;
		}
	}

	private void compute() {
		this.total = items.stream().mapToDouble(Product::getPrice).sum();
		this.discount = discountStrategy.discount(this);
		this.payableAmount = this.total - this.discount;
	}

	public Cart addItem(Product product) {
		items.add(product);
		compute();
		return this;
	}

	public Cart removeItem(Product product) {
		items.remove(product);
		compute();
		return this;
	}

	public List<Product> getItems() {
		return items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getTotal() {
		return total;
	}

	public double getDiscount() {
		return discount;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

}
