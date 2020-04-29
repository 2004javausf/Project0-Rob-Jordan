package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;

public class AccountDAOImpl implements AccountDAO{
	public static List<Account> accountList = new ArrayList<Account>();
	
	public void createAccounts() {
		Account account1 = new Account(1, 0, "checkings");
		Account account2 = new Account(2, 0, "savings");
		accountList.add(account1);
		accountList.add(account2);
	}
	

}
