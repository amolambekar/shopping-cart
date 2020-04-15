package com.eshopper;

public class Bill {

	private Customer customer;

	private Long purchaseAmount;

	public Bill(Customer customer, Long purchaseAmount) {
		this.customer = customer;
		this.purchaseAmount = purchaseAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Long getPurchaseAmount() {
		return purchaseAmount;
	}

	public Long finalAmount() {
		return Discount.getDiscountScheme(customer.getCustomerType()).apply(purchaseAmount);
	}

}
