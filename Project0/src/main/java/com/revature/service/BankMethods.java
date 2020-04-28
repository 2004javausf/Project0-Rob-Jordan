package com.revature.service;

import com.revature.beans.Account;

public class BankMethods {
	
	public void withdraw(Account account, double amount) {
		account.setAccountBalance(account.getAccountBalance()-amount);
	}
	
	public void deposit(Account account, double amount) {
		account.setAccountBalance(account.getAccountBalance() + amount);
	}
	
	public void transfer(Account account1, Account account2, double amount) {
		double tempValue = 0;
		tempValue = account1.getAccountBalance() - amount;
		account2.setAccountBalance(account2.getAccountBalance()+tempValue);
	}

}
