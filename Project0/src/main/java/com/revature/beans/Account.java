package com.revature.beans;

import java.util.Scanner;

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
	
	//To make Deposits
	public double addTo(double amount) {
		if(amount != 0) {
			accountBalance = accountBalance + amount;
			//System.out.println("Your new balance is: " + accountBalance);
		}
		else if (amount < 0) {
			//System.out.println("Amount can not be a negative number");
		}
		
		return amount;
	}
	public double deposit(double amount) {
		
		if(amount != 0) {
			accountBalance = accountBalance + amount;
			//System.out.println("Your new balance is: " + accountBalance);
			
			}
			else if (amount < 0) {
				System.out.println("Amount can not be a negative number");
			
		}
		return accountBalance;
	}
	
	//To withdraw
	
	public double subtractFrom(double amount) {
		if(amount != 0) {
			accountBalance = accountBalance - amount;
			//System.out.println("Your new balance is: " + accountBalance);
		}
		else if (amount < 0) {
			//System.out.println("Amount can not be a negative number");
		}
		
		return amount;
	}
	public double withdraw(double amount) {
		
		if(amount != 0) {
			accountBalance = accountBalance - amount;
			//System.out.println("Your new balance is: " + accountBalance);
		}
		else if (amount < 0) {
			//System.out.println("Amount can not be a negative number");
		}
		
		return accountBalance;
		
	}
	
//	//To make transfers
//	public void transfer(double amount) {
//		
//		double tempBalance = 0;
//		if(amount != 0) {
//		tempBalance = this.accountBalance - amount;
//		Scanner sc = new Scanner(System.in);
//		int input = sc.nextInt();
//		if (input == 2) {
//			a2.deposit(tempBalance);
//		}
//		
//		
//		}	
//	}
	


}
