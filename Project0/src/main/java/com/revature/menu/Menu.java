package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.CustomerDAOImpl;
import com.revature.io.CustomerIO;
import com.revature.service.BankMethods;

public class Menu {
		
		static Scanner scan = new Scanner(System.in);
		public static void startMenu() {
			CustomerIO.readCustomerFile();
			System.out.println("Welcome to your favorite bank!");
			System.out.println("Press 1 to Log in");
			System.out.println("Press 2 for other services");
			System.out.println("Press 3 to exit");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
//				LogIn
				Scanner textInput = new Scanner(System.in);
				List<Customer> cList = CustomerDAOImpl.customerList;
				List<Account> accList = AccountDAOImpl.accountList;
				System.out.println("Enter your user name.");
				String userName = textInput.nextLine();
				System.out.println("Enter your password.");
				String password = textInput.nextLine();
				for (int i = 0; i <cList.size() ; i++) {
					if(cList.get(i).getUserName().equals(userName) && cList.get(i).getPassword().equals(password)) {
						Customer customer = cList.get(i);
						Account account = accList.get(i);
						if(cList.get(i).getAccountNumber() == accList.get(i).getAccountNumber())
						account = accList.get(i);
						
						transactionMenu(accList, cList);
					}
				}
				break;
			case 2:
//				otherServicesMenu();
				break;
			case 3:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Please enter a valid option");
				startMenu();
				break;
			}
		}
		
		public static void transactionMenu(Account account, Customer customer) {
			System.out.println("What kind of transaction would you like to process?");
			System.out.println("Press 1 to deposit");
			System.out.println("Press 2 to withdaw");
			System.out.println("Press 3 to transfer");
			System.out.println("Press 4 to Main Menu");
			System.out.println("Press 5 to exit");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("How much do you want to deposit?");
				double dep = scan.nextDouble();
				BankMethods.deposit(account, dep);
				break;
			case 2:
				System.out.println("How much do you want to withdraw?");
				double with = scan.nextDouble();
				BankMethods.withdraw(account, with);
				break;
			case 3:
				
				break;
			case 4:
				startMenu();
				break;
			case 5:
				
				break;
			}
		}

}
