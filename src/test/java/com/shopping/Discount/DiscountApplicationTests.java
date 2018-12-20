package com.shopping.Discount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.Cart;
import com.shopping.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountApplicationTests {

	// Testing for employee when purchase is greater than 100
	@Test
	public void billingForEmployeeWithHunderedDiscount() {

		Cart cart = new Cart(new Customer("Rahul", CustomerType.EMPLOYEE, "2012-08-16"));

		Product product1 = new Product("Product1", 10.0, false);
		Product product2 = new Product("Product2", 20.0, false);
		Product product3 = new Product("Product3", 30.0, true);
		Product product4 = new Product("Product4", 40.0, true);
		Product product5 = new Product("Product5", 50.0, true);

		cart.addItem(product1).addItem(product2).addItem(product3).addItem(product4).addItem(product5);
		assertEquals(150.0, cart.getTotal(), 0.0);
		assertEquals(14.0, cart.getDiscount(), 0.0);
		assertEquals(136.0, cart.getPayableAmount(), 0.0);

	}

	// Testing for employee when purchase is less than 100
	@Test
	public void billingForEmployeeWithoutHunderedDiscount() {

		Cart cart = new Cart(new Customer("Rahul", CustomerType.EMPLOYEE, "2012-08-16"));

		Product product1 = new Product("Product1", 10.0, false);
		Product product2 = new Product("Product2", 20.0, false);
		Product product3 = new Product("Product3", 30.0, true);
		Product product4 = new Product("Product4", 30.0, true);

		cart.addItem(product1).addItem(product2).addItem(product3).addItem(product4);
		assertEquals(90.0, cart.getTotal(), 0.0);
		assertEquals(9.0, cart.getDiscount(), 0.0);
		assertEquals(81.0, cart.getPayableAmount(), 0.0);

	}

	// Testing for employee when only groceries are purchased and total amount
	// is less than 100
	@Test
	public void billingForEmployeeWithAllgroceries() {

		Cart cart = new Cart(new Customer("Rahul", CustomerType.EMPLOYEE, "2012-08-16"));

		Product product1 = new Product("Product1", 10.0, true);
		Product product2 = new Product("Product2", 20.0, true);
		Product product3 = new Product("Product3", 30.0, true);

		cart.addItem(product1).addItem(product2).addItem(product3);
		assertEquals(60.0, cart.getTotal(), 0.0);
		assertEquals(0, cart.getDiscount(), 0.0);
		assertEquals(60.0, cart.getPayableAmount(), 0.0);

	}

	// Testing for affiliate customer when total bill is more than 100
	@Test
	public void testBillingForAffiliate() {

		Cart cart = new Cart(new Customer("Rahul", CustomerType.AFFLIATE, "2012-08-16"));

		Product product1 = new Product("Product1", 210.0, false);
		Product product2 = new Product("Product2", 20.0, false);
		Product product3 = new Product("Product3", 30.0, true);
		Product product4 = new Product("Product4", 40.0, true);
		Product product5 = new Product("Product5", 50.0, true);

		cart.addItem(product1).addItem(product2).addItem(product3).addItem(product4).addItem(product5);
		assertEquals(350.0, cart.getTotal(), 0.0);
		assertEquals(38.0, cart.getDiscount(), 0.0);
		assertEquals(312.0, cart.getPayableAmount(), 0.0);

	}

	// Testing for privileged (associated for more than 2 years) customer when
	// total bill is more than 100
	@Test
	public void testBillingForPrivileged() {

		Cart cart = new Cart(new Customer("Rahul", CustomerType.GENERAL, "2012-08-16"));

		Product product1 = new Product("Product1", 10.0, false);
		Product product2 = new Product("Product2", 20.0, false);
		Product product3 = new Product("Product3", 30.0, true);
		Product product4 = new Product("Product4", 40.0, true);
		Product product5 = new Product("Product5", 50.0, true);

		cart.addItem(product1).addItem(product2).addItem(product3).addItem(product4).addItem(product5);
		assertEquals(150.0, cart.getTotal(), 0.0);
		assertEquals(6.5, cart.getDiscount(), 0.0);
		assertEquals(143.5, cart.getPayableAmount(), 0.0);

	}

	// Testing for normal customer when total bill is more than 100
	@Test
	public void testBillingForNormal() {

		Cart cart = new Cart(new Customer("Rahul", CustomerType.GENERAL, "2018-08-16"));

		Product product1 = new Product("Product1", 110.0, false);
		Product product2 = new Product("Product2", 20.0, false);
		Product product3 = new Product("Product3", 30.0, true);
		Product product4 = new Product("Product4", 40.0, true);
		Product product5 = new Product("Product5", 50.0, true);

		cart.addItem(product1).addItem(product2).addItem(product3).addItem(product4).addItem(product5);
		assertEquals(250.0, cart.getTotal(), 0.0);
		assertEquals(10.0, cart.getDiscount(), 0.0);
		assertEquals(240.0, cart.getPayableAmount(), 0.0);

	}

	// Testing for normal customer when total bill is less than 100
	@Test
	public void testBillingForNormalWithoutDiscount() {

		Cart cart = new Cart(new Customer("Rahul", CustomerType.GENERAL, "2018-08-16"));

		Product product1 = new Product("Product1", 10.0, false);
		Product product2 = new Product("Product2", 20.0, false);
		Product product3 = new Product("Product3", 30.0, true);
		Product product4 = new Product("Product4", 39.0, true);

		cart.addItem(product1).addItem(product2).addItem(product3).addItem(product4);
		assertEquals(99.0, cart.getTotal(), 0.0);
		assertEquals(0, cart.getDiscount(), 0.0);
		assertEquals(99.0, cart.getPayableAmount(), 0.0);

	}

}
