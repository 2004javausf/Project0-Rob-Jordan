package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;

public class AccountDAOImpl implements AccountDAO{
	public static List<Account> accountList = new ArrayList<Account>();
	
	public void createAccounts() {
		Account account1 = new Account(1, 0, "checkings");
		Account account2 = new Account(2, 0, "savings");
		accountList.add(account1);
		accountList.add(account2);
	}
	
	public static Account findByAccountNumber(int num) {
		for(int i = 0; i < AccountDAOImpl.accountList.size(); i++) {
			int accountNumber = AccountDAOImpl.accountList.get(i).getAccountNumber();
			if(accountNumber == num ) {
				return AccountDAOImpl.accountList.get(i);
			}
		}
		System.out.println("Employee not found");
		
		return null;
	}
	

}
