package com.revature.beans;

public class Account {
	
	private int accountNumber;
	private double accountBalance;
	private int customerID;
	
	public Account(int accountNumber, double accountBalance, int customerID) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.customerID = customerID;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


}
