package com.revature.bankMethods;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.beans.Account;
import com.revature.service.BankMethods;

class BankMethodsTest {
	Account account1 = new Account(1, 100);
	Account account2 = new Account(1, 200);
	BankMethods activity = new BankMethods();

	@Test
	@DisplayName("Test if money is withdrawn from an account")
	void withdrawTest() {
		//Test to see if money will be withdrawn from an account.
		activity.withdraw(account1, 90);
		assertEquals(10, account1.getAccountBalance());
	}
	
	@Test
	@DisplayName("Test if money will be deposited to an account")
	void depositTest() {
		//Should deposit money from an account.
		activity.deposit(account2, 50);
		assertEquals(250, account2.getAccountBalance());
	}
	
	@Test
	@DisplayName("Transfer money between accounts")
	void transferTest() {
		//Transfer from one account to another
		activity.transfer(account1, account2, 50);
		assertEquals(50, account1.getAccountBalance());
		assertEquals(250, account2.getAccountBalance());
	}

}
