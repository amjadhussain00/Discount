package com.shopping;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping.model.Customer;
import com.shopping.model.CustomerType;
import com.shopping.model.Product;

@SpringBootApplication
public class DiscountApplication {

	public static void main(String[] args) {
		Cart cart = new Cart(new Customer("Rahul", CustomerType.AFFLIATE, "2012-08-16"));

		Product product1 = new Product("Product1", 10.0, false);
		Product product2 = new Product("Product2", 20.0, false);
		Product product3 = new Product("Product3", 30.0, true);
		Product product4 = new Product("Product4", 40.0, true);
		Product product5 = new Product("Product5", 50.0, true);

		cart.addItem(product1).addItem(product2).addItem(product3).addItem(product4).addItem(product5);
		System.out.println("Total : " + cart.getTotal() + " , Discount : " + cart.getDiscount() + " , Total Payable : "
				+ cart.getPayableAmount());
	}

}
