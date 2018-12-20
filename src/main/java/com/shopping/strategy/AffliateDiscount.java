package com.shopping.strategy;

import com.shopping.Cart;
import com.shopping.model.Discount;

public class AffliateDiscount implements DiscountStrategy{

	@Override
	public double discount(Cart cart) {
		double amount = totalPercentDiscountableAmount(cart);
		double discount1 = amount * Discount.AFFLIATE.percent / 100;
		double discount2 = additionalDiscount(cart);
		return discount1 + discount2;
	}

	
}
