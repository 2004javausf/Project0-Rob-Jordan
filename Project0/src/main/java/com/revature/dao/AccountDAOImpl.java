package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;

public class AccountDAOImpl implements AccountDAO{
	public static List<Account> accountList = new ArrayList<Account>();
	
	public void createAccounts() {
		Account checking = new Account(1, 0);
		Account savings = new Account(2, 0);
		accountList.add(checking);
		accountList.add(savings);
	}
	

}
