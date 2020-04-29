package com.revature.driver;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.io.AccountsIO;

public class AccountDriver {
	
	
			

	public static void main(String[] args) {
//		CustomerIO.readCustomerFile();
		AccountsIO.readAccountFile();
		
		
		CustomerDAO customer = AccountDriver.getCustomerDAO();
		AccountDAO accounts = AccountDriver.getAccountDAO();
		
		System.out.println(AccountDAOImpl.accountList);
	}
		
	public static CustomerDAO getCustomerDAO() {
		return new CustomerDAOImpl();
	}
	
	public static AccountDAO getAccountDAO() {
		return new AccountDAOImpl();
	}
}
