package com.eshopper;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.eshopper.Customer.CustomerType;


public class ShoppingCartTest {
	
	@Test
	public void when_customer_type_is_regular_then_for_purchase_amount_of_15000$_final_bill_after_discount_will_be_13500() {
		Customer customerA = new Customer("A", CustomerType.REGULAR);
		Bill billA = new Bill(customerA,15000l);
		assertTrue(billA.finalAmount()==13500);
	}
	
	@Test
	public void when_customer_type_is_regular_then_for_purchase_amount_of_5000_then_no_discount_is_applied() {
		Customer customerA = new Customer("A", CustomerType.REGULAR);
		Bill bill = new Bill(customerA,5000l);
		assertTrue(bill.finalAmount()==5000l);
	}
	
	
	
	@Test
	public void when_customer_type_is_premium_then_for_purchase_amount_of_20000l$_final_bill_after_discount_will_be_15800() {
		Customer customerB = new Customer("B", CustomerType.PREMIUM);
		Bill bill = new Bill(customerB,20000l);
		assertTrue(bill.finalAmount()==15800);
		 
	}
	
	@Test
	public void when_customer_type_is_gold_then_for_purchase_amount_of_20000l$_final_bill_after_discount_will_be_14600() {
		Customer customerB = new Customer("B", CustomerType.GOLD);
		Bill bill = new Bill(customerB,20000l);
		assertTrue(bill.finalAmount()==14600);
		 
	}
	
	@Test
	public void when_a_discount_is_not_available_for_specific_customer_type_then_final_bill_amount_is_purchase_amount() {
		Customer customerB = new Customer("B", CustomerType.NO_DISCOUNT);
		Bill bill = new Bill(customerB,20000l);
		System.out.println(bill.finalAmount());
		assertTrue(bill.finalAmount()==20000l);
		 
	}
	
	
	 
	

}
