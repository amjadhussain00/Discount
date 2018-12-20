package com.shopping.strategy;

import com.shopping.Cart;
import com.shopping.model.Discount;

public class EmployeeDiscount implements DiscountStrategy {

	@Override
	public double discount(Cart cart) {
		double amount = totalPercentDiscountableAmount(cart);
		double discount1 = amount * Discount.EMPLOYEE.percent / 100;
		double discount2 = additionalDiscount(cart);
		return discount1 + discount2;
	}

}
