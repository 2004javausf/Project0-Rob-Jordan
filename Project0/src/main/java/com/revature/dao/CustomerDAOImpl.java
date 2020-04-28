package com.revature.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.io.CustomerIO;

public class CustomerDAOImpl implements CustomerDAO {
	public static List<Customer> customerList = new ArrayList<Customer>();

	@Override
	public void createCustomer() {
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
			System.out.println("Come up with a password.");
			password = textInput.nextLine();
			System.out.println("What kind account do you want to open?");
			System.out.println("1.) Checking 2.) Saving");
			answer = intInput.nextInt();
			if(answer ==1) {
				accountNumber = 1;
			}else if( answer ==2) {
				accountNumber = 2;
			}
			
			Customer  customer = new Customer(1,firstName, lastName, userName, password, accountNumber, phoneNumber,status_code);
			
		}

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
