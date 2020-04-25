package com.revature.accountmethods;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.beans.Account;

class AccountMethodsTest {

	@Test
	@DisplayName("Testing deposits")
	void depositTest() {
		Account a1 = new Account(892, 43.31, 4893);
		a1.deposit(43.12);
		System.out.println(a1.getAccountBalance());
		assertEquals(86.43, a1.getAccountBalance());
	}
	
	@Test
	@DisplayName("Testing withdrawals")
	void withdrawalsTest() {
		Account a1 = new Account(892, 43.31, 4893);
		a1.withdraw(43.31);
		System.out.println(a1.getAccountBalance());
		assertEquals(0, a1.getAccountBalance());
	}
	

}
