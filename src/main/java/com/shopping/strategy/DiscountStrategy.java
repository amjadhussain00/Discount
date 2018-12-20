package com.shopping.strategy;

import com.shopping.Cart;
import com.shopping.model.Discount;
import com.shopping.model.Product;


public interface DiscountStrategy {

	public double discount(Cart cart);
	
	default double totalPercentDiscountableAmount(Cart cart){
		return cart.getItems().stream().filter(Product::isNotGrocery).mapToDouble(Product::getPrice).sum();
	}

	default double additionalDiscount(Cart cart) {
		int hunderedDollarBillMultiplyFactor = (int) cart.getTotal() / 100;
		return Double.valueOf(hunderedDollarBillMultiplyFactor * 100) * Discount.TOTAL.percent / 100;
	}

}
