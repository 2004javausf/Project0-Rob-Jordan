package com.revature.service;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.io.AccountsIO;

public class BankMethods {
	
	public static void withdraw(Account account, double amount) {
		account.setAccountBalance(account.getAccountBalance()-amount);
		AccountsIO.writeAccountFile();
	}
	
	public static void deposit(Account account, double amount) {
		account.setAccountBalance(account.getAccountBalance() + amount);
		AccountsIO.writeAccountFile();
	}
	
	public static void transfer(Account account1, Account account2, double amount) {
		account1.setAccountBalance(account1.getAccountBalance()-amount);
		account2.setAccountBalance(account2.getAccountBalance()+amount);
		AccountsIO.writeAccountFile();
	}
	
	public static void approveDeny(Customer customer) {
		if(customer.getIsApproved() == true) {
		customer.setApproved(false); 	
		}else {
			customer.setApproved(true);
		}
	}
	

}
