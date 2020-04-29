package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revarture.driver.AccountDriver;

public class Menu {
		
		static Scanner scan = new Scanner(System.in);
		public static void startMenu() {
			System.out.println("Welcome to your favorite bank!");
			System.out.println("Press 1 to Log in");
			System.out.println("Press 2 for other services");
			System.out.println("Press 3 to exit");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				transactionMenu();
				break;
			case 2:
				otherServicesMenu();
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
		
		public static void transactionMenu() {
			System.out.println("What kind of transaction would you like to process?");
			System.out.println("Press 1 to deposit");
			System.out.println("Press 2 to withdaw");
			System.out.println("Press 3 to transfer");
			System.out.println("Press 4 to Main Menu");
			System.out.println("Press 5 to exit");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				
				break;
			case 2:
				
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
