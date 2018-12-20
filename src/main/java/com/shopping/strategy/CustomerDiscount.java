package com.shopping.strategy;

import java.time.LocalDate;

import com.shopping.Cart;
import com.shopping.model.Discount;

public class CustomerDiscount implements DiscountStrategy {

	@Override
	public double discount(Cart cart) {
		double amount = totalPercentDiscountableAmount(cart);

		LocalDate today = LocalDate.now();
		double discountPercent = cart.getCustomer().getFirstPurchaseDate().isBefore(today.minusYears(2))
				? Discount.PRIVILEGED.percent : Discount.GENERAL.percent;

		double discount1 = amount * discountPercent / 100;
		double discount2 = additionalDiscount(cart);
		return discount1 + discount2;
	}

}
