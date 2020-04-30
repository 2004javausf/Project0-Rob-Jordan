package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.io.AccountsIO;
import com.revature.io.CustomerIO;
import com.revature.service.BankMethods;

public class CustomerDAOImpl implements CustomerDAO {
	public static List<Customer> customerList = new ArrayList<Customer>();

	@Override
	public void createCustomer() {
		CustomerIO.readCustomerFile();
		AccountsIO.readAccountFile();
		List<Customer> cList = CustomerDAOImpl.customerList;
		List<Account>  accList = AccountDAOImpl.accountList;
		Scanner intInput = new Scanner(System.in);
		Scanner textInput = new Scanner(System.in);
		Scanner longInput = new Scanner(System.in);
		int answer = 0;

		String firstName;
		String lastName;
		String userName;
		String password;
		int accountNumber = 0;
		long phoneNumber = 0;
		int status_code =0;
		boolean isApproved = false;
		

		//Code for giving out a status code.
			System.out.println("Are you registering as an 1.)Customer or an 2.)Employee?");
			answer =intInput.nextInt();
			if(answer == 1) {
				status_code = 1;
				answer = 0;
			}else if(answer == 2) {
				status_code = 2;
				answer =0;
			}
		//END OF STATUS CODE BLOCK
			System.out.println("What is your first name?");
			firstName = textInput.nextLine();
			System.out.println("What is your last name?");
			lastName = textInput.nextLine();
			System.out.println("What is your telephone number?");
			phoneNumber = longInput.nextLong();
			System.out.println("Make a user name.");
			userName = textInput.nextLine();
			for (int i = 0; i < cList.size(); i++) {
				while (userName.equals(cList.get(i).getUserName())) {
					System.out.println("That name has been taken. Try another one.");
					userName = textInput.nextLine();
				}
			}
			System.out.println("Come up with a password.");
			password = textInput.nextLine();
			System.out.println("What kind account do you want to open?");
			System.out.println("1.) Checking 2.) Saving");
			answer = intInput.nextInt();
			if(answer ==1) {
				accountNumber = accList.size() + 1;
				double accountBalance = 0;
				String accountName = "Checking";	
				Account account = new Account(accountNumber, accountBalance, accountName);
			}else if( answer == 2) {
				accountNumber = accList.size() + 1;
				double accountBalance = 0;
				String accountName = "Savings";
				Account account = new Account(accountNumber, accountBalance, accountName);
			}
			
			System.out.println("Would you like to make another account? Y/N");
			String choice = textInput.nextLine();
			if(choice.equalsIgnoreCase("y")) {
				createCustomer();
			}else if(choice.equalsIgnoreCase("n")) {
				System.out.println("Thank you!");
			}
			
			Customer  customer = new Customer(1,firstName, lastName, userName, password, accountNumber, phoneNumber,status_code, isApproved);
			
		}
	
	public static Customer findCustomerByUserName(String inputUserName) {
		for(int i = 0; i < CustomerDAOImpl.customerList.size(); i++) {
			String name = CustomerDAOImpl.customerList.get(i).getUserName();
			if(inputUserName.equals(name)) {
				return CustomerDAOImpl.customerList.get(i);
			}
		}
		System.out.println("Employee not found");
		
		return null;
	}
	
	public static Customer findCustomerPassword(String inputPassword) {
		for(int i = 0; i < CustomerDAOImpl.customerList.size(); i++) {
			String password = CustomerDAOImpl.customerList.get(i).getPassword();
			if(inputPassword.equals(password)) {
				return CustomerDAOImpl.customerList.get(i);
			}
		}
		System.out.println("Password does not match");
		
		return null;
	}
	
	
//	public static void main(String[] args) {
//		CustomerIO.readCustomerFile();
//		AccountsIO.readAccountFile();
//		BankMethods activity = new BankMethods();
////		System.out.println(CustomerDAOImpl.customerList);
////		System.out.println(AccountDAOImpl.accountList);
//		List<Customer> cList = CustomerDAOImpl.customerList;
//		List<Account>  accList = AccountDAOImpl.accountList;
//		for (int i = 0; i < cList.size()-1; i++) {
//			if(accList.get(i).getAccountNumber() == cList.get(i).getAccountNumber()) {
//				activity.deposit(accList.get(i), 50);
//			}
//		}
//		System.out.println(CustomerDAOImpl.customerList);
//		System.out.println(AccountDAOImpl.accountList);
//	}

//	@Override
//	public List<Customer> getCustomers() {
//		IOWithCollections.readHumanFile();
//
//		return Roster.customerList;
//		
//
//		
//		
//	}
	
}
