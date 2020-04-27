package com.revature.driver;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.io.IOWithCollections;

public class AccountDriver {
	
	
			

	public static void main(String[] args) {
		int i = 0;
		
//		//This allows customer to apply for an account.
		CustomerDAO customer = AccountDriver.getCustomerDAO();
//		//Also automatically writes then reads to the file.
//		customer.createCustomer();
//		
		List<Object> cList = customer.getCustomers();
		System.out.println(cList);		
	}
		
	public static CustomerDAO getCustomerDAO() {
		return new CustomerDAOImpl();
	}
		
//	public static void notCompletedTransferMethod() {
//		Scanner input = new Scanner(System.in);
//		
//		Account a1 = new Account(3344, 89.00, 999);
//		Account a2 = new Account(3345, 76.00, 888);
//
//		System.out.println("How much would you like to transfer?");
//		double tempBalance = input.nextDouble();
//		tempBalance = a1.subtractFrom(tempBalance);
//		System.out.println("Where would you like to transfer?");
//		int answer = input.nextInt();
//		if(answer == 1) {
//			a2.addTo(tempBalance);
//			System.out.println("Here's your new account balance: " + a2.getAccountBalance());
//	}
//}
		


}
