package com.revature.beans;

import java.io.Serializable;

import com.revature.dao.AccountDAOImpl;
import com.revature.io.AccountsIO;

public class Account implements Serializable {
	
	
	private static final long serialVersionUID = 5449754227444174307L;
	private int accountNumber;
	private double accountBalance;
	private String accountName;
	
	public Account(int accountNumber, double accountBalance, String accountName) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountName = accountName;
		AccountDAOImpl.accountList.add(this);
		AccountsIO.writeAccountFile();
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", accountName="
				+ accountName + "]";
	}
	
}
