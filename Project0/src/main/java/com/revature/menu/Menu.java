package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImpl;
import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.io.AdminIO;
import com.revature.io.CustomerIO;
import com.revature.io.EmployeeIO;
import com.revature.service.BankMethods;

public class Menu {
	static BankMethods bankMethods = new BankMethods();
	
	
		
		static Scanner scan = new Scanner(System.in);
		public static void startMenu() {
			CustomerIO.readCustomerFile();
			EmployeeIO.readEmployeeFile();
			AdminIO.readAdminFile();
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
				
				CustomerDAOImpl.findCustomerPassword(password);
				Customer customer = CustomerDAOImpl.findCustomerByUserName(userName);
				if(customer == null) 
					startMenu();
				Account account = AccountDAOImpl.findByAccountNumber(customer.getAccountNumber());
				transactionMenu(account, customer);
				break;
			case 2:
				otherServicesMenu();
				break;
			case 3:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Please enter a valid option.");
				startMenu();
				break;
			}
		}
		
		public static void transactionMenu(Account account, Customer customer) {
			Scanner doubleScan = new Scanner(System.in);
			Scanner intScan = new Scanner(System.in);
			System.out.println("What kind of transaction would you like to process?");
			System.out.println("Press 1 to deposit");
			System.out.println("Press 2 to withdaw");
			System.out.println("Press 3 to transfer");
			System.out.println("Press 4 to go to the Main Menu");
			System.out.println("Press 5 to exit");
			int choice =Integer.parseInt(intScan.nextLine());
			switch(choice) {
			case 1:
				System.out.println("Your current balanace is: "+ "$" +account.getAccountBalance());
				System.out.println("How much do you want to deposit?");
				double dep = doubleScan.nextDouble();
				System.out.println("Your new balance is: " + "$" +(account.getAccountBalance() + dep));
				BankMethods.deposit(account, dep);
				transactionMenu(account, customer);
				break;
			case 2:
				System.out.println("Your current balanace is: "+ "$" +account.getAccountBalance());
				System.out.println("How much do you want to withdraw?");
				double with = scan.nextDouble();
				System.out.println("Your new balance is: " + "$" + (account.getAccountBalance() - with));
				BankMethods.withdraw(account, with);
				transactionMenu(account, customer);
				break;
			case 3:
				
				break;
			case 4:
				startMenu();
				break;
			case 5:
				
				break;
			default:
				System.out.println("Please enter a valid option.");
			}
			
		}
		
		public static void otherServicesMenu() {
			System.out.println("What would you like to do?");
			System.out.println("Press 1 to Create an account");
			System.out.println("Press 2 to Log in as an Employee");
			System.out.println("Press 3 to Log in as an Administrator");
			int choice = scan.nextInt();
			switch(choice) {	
				case 1:
					System.out.println("Press 1 to apply for an account");
					System.out.println("Press 2 to register as an employee");
					System.out.println("Press 3 to regiser as an admin");
					int choice2 = scan.nextInt();
					switch(choice2) {
					case 1:
						getCustomerDAO().createCustomer();
						System.out.println("Your application was submitted! Please check status after 24 hours");
						break;
					case 2:
						getEmployeeDAO().createEmployee();
						otherServicesMenu();
						break;
					case 3:
						getAdminDAO().createAdmin();
						otherServicesMenu();
						break;
					default:
					}
					
					break;
				case 2:
					Scanner employeeLogIn = new Scanner(System.in);
					System.out.println("Enter your user name");
					String  userInput = employeeLogIn.nextLine();
					System.out.println("Enter your password");
					String inputPassword = employeeLogIn.nextLine();
					EmployeeIO.findEmployeePassword(inputPassword);
					Employee employee = EmployeeIO.findEmployeeByUserName(userInput);
					if(employee == null) {
						System.out.println("Credentials don't match");
						otherServicesMenu();
					}
					employeeMenu();
					break;
//				case 3:
//					System.out.println("Enter your user name");
//					String userInput = scan.nextLine();
//					EmployeeIO.findAdminByUserName(userInput);
//					System.out.println("Enter your password");
//					String inputPassword = scan.nextLine();
//					EmployeeIO.findAdminPassword(inputPassword);
//					adminMenu();
//					break;
			}
			
		}
		
		public static void employeeMenu() {
			int choice;
			Scanner sc = new Scanner(System.in);
			Scanner in = new Scanner(System.in);
			System.out.println("Press 1 to View Customer List");
			System.out.println("Press 2 to View Customer's information");
			System.out.println("Press 3 to Approve/Deny Applications");
			choice = in.nextInt();
			switch (choice) {
				case 1:
					System.out.println(CustomerDAOImpl.customerList);
					System.out.println("Press any key to go back to the employee menu");
					sc.next();
					employeeMenu();		
				break;
				case 2:
					Scanner textInput = new Scanner(System.in);
					System.out.println("Enter the Customer's Username.");
					String userName = textInput.nextLine();				
					Customer customer = CustomerDAOImpl.findCustomerByUserName(userName);
					System.out.println(customer);
					System.out.println("Press any key to go back to the employee menu");
					sc.next();
					employeeMenu();	
					break;
				case 3:
					Scanner textInput2 = new Scanner(System.in);
					System.out.println("Enter the Customer's Username.");
					String userName2 = textInput2.nextLine();				
					Customer customer2 = CustomerDAOImpl.findCustomerByUserName(userName2);
					BankMethods.approveDeny(customer2);
					employeeMenu();
					break;
			default:
				System.out.println("Please enter a valid choice");
				employeeMenu();
				break;
			}
		}
		
		public static CustomerDAO getCustomerDAO() {
			return new CustomerDAOImpl();
		}
		
		public static EmployeeDAO getEmployeeDAO() {
			return new EmployeeDAOImpl();
		}
		
		public static AdminDAO getAdminDAO() {
			return new AdminDAOImpl();
		}

}
