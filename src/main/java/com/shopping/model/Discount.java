package com.shopping.model;

public enum Discount {

	EMPLOYEE(30.0), AFFLIATE(10.0), PRIVILEGED(5.0), GENERAL(0.0), TOTAL(5.0);

	public double percent;

	private Discount(double percent) {
		this.percent = percent;
	}

}
