package com.revature.driver;
import java.util.Scanner;

import com.revature.beans.Customer;

public class AccountDriver {
	
	
			

	public static void main(String[] args) {
		Scanner intInput = new Scanner(System.in);
		Scanner textInput = new Scanner(System.in);
		Scanner longInput = new Scanner(System.in);
		
		String firstName;
		String lastName;
		String userName;
		String password;
		int accountNumber = 0;
		long phoneNumber = 0;
		int status_code =0;
		
		System.out.println("Hello! To \"Log In\" press 1. To \"Create an Account\" press 2.");
		
		int answer = intInput.nextInt();
		if(answer ==1) {
			
		}else if(answer == 2) {
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
			Customer  c1 = new Customer(1,firstName, lastName, userName, password, accountNumber, phoneNumber,status_code);
			System.out.println(c1);
			
		}
		
		
		
		
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
