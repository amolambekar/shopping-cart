package com.eshopper;

public class Customer {
	
	public enum CustomerType 
	
	 {
		REGULAR,PREMIUM, GOLD,NO_DISCOUNT
		 
		 };
		    	
	private String name;
	
	private CustomerType customerType;
	
	

	public Customer(String name, CustomerType customerType) {
		super();
		this.name = name;
		this.customerType = customerType;
	}

	public String getName() {
		return name;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}
	

	
	
	
	
	 
	

}
