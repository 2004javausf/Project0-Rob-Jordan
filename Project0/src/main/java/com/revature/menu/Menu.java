package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.AdminDAO;
import com.revature.dao.AdminDAOImpl;
import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.io.AccountsIO;
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
			System.out.println("Welcome to J&R bank!");
			System.out.println("Press 1.) to Log in");
			System.out.println("Press 2.) for Other Services");
			System.out.println("Press 3.) Exit");
			int choice1 = scan.nextInt();
			switch(choice1) {
			case 1:
//				LogIn
				Scanner textInput = new Scanner(System.in);
				List<Customer> cList = CustomerDAOImpl.customerList;
				List<Account> accList = AccountDAOImpl.accountList;
				System.out.println("Enter your user name.");
				String userName = textInput.nextLine();
				System.out.println("Enter your password.");
				String password = textInput.nextLine();
				
				Customer cuPass = CustomerDAOImpl.findCustomerPassword(password);
				Customer customer = CustomerDAOImpl.findCustomerByUserName(userName);
				if(customer == null || cuPass == null) 
					startMenu();
				Account account = AccountDAOImpl.findByAccountNumber(customer.getAccountNumber());
				if(customer.getIsApproved() == false) {
					System.out.println(" Your current account status is pending. \n Please check back when your account has been approved.");
					startMenu();
				}
				transactionMenu(account, customer);
				break;
			case 2:
				otherServicesMenu();
				break;
			case 3:
				System.out.println("Thank you for Banking With Us!");
				System.exit(1);
				break;
			default:
				System.out.println("Please enter a valid option.");
				startMenu();
				break;
			}
		}
		
		public static void transactionMenu(Account account, Customer customer) {
			Scanner txtInput = new Scanner(System.in);
			Scanner dblInput = new Scanner(System.in);
			Scanner doubleScan = new Scanner(System.in);
			Scanner intScan = new Scanner(System.in);
			System.out.println("What kind of transaction would you like to process?");
			System.out.println("Press 1.) to deposit");
			System.out.println("Press 2.) to withdaw");
			System.out.println("Press 3.) to transfer");
			System.out.println("Press 4.) to go to the Main Menu");
			System.out.println("Press 5.) to exit");
			int choice2 =Integer.parseInt(intScan.nextLine());
			switch(choice2) {
			case 1:
				System.out.println("Your current balanace is: "+ "$" +account.getAccountBalance());
				System.out.println("How much do you want to deposit?");
				double dep = doubleScan.nextDouble();
				System.out.println("Your new balance is: " + "$" +(account.getAccountBalance() + dep));
				BankMethods.deposit(account, dep);
				AccountsIO.writeAccountFile();
				transactionMenu(account, customer);
				break;
			case 2:
				System.out.println("Your current balanace is: "+ "$" +account.getAccountBalance());
				System.out.println("How much do you want to withdraw?");
				double with = scan.nextDouble();
				System.out.println("Your new balance is: " + "$" + (account.getAccountBalance() - with));
				BankMethods.withdraw(account, with);
				AccountsIO.writeAccountFile();
				transactionMenu(account, customer);
				break;
			case 3:
				System.out.println("Enter the user name of the account you want to transfer to.");
				String accountInput = txtInput.nextLine();
				Customer customer2 = CustomerDAOImpl.findCustomerByUserName(accountInput);
				Account account2 = AccountDAOImpl.findByAccountNumber(customer2.getAccountNumber());
				System.out.println("How much money do you want to transfer?");
				System.out.println(customer.getFirstName()+ "'s "+ "acccount balance is: $" + account.getAccountBalance());
				double amount = dblInput.nextDouble();
				BankMethods.transfer(account, account2, amount);
				AccountsIO.writeAccountFile();
				System.out.println(customer.getFirstName()+ "'s "+ "acccount balance is now: $" + (account.getAccountBalance()));
				transactionMenu(account, customer);
				break;
			case 4:
				startMenu();
				break;
			case 5:
				System.out.println("Thank you for Banking With Us!");
				System.exit(1);
				break;
			default:
				System.out.println("Please enter a valid option.");
				break;
			}
			
		}
		
		public static void otherServicesMenu() {
			System.out.println("What would you like to do?");
			System.out.println("Press 1.) to Create an account");
			System.out.println("Press 2.) to log in as an Employee");
			System.out.println("Press 3.) to log in as an Administrator");
			System.out.println("Press 4.) for Main Menu");
			System.out.println("Press 5.) Exit.");
			int choice3 = scan.nextInt();
			switch(choice3) {	
				case 1:
					System.out.println("Press 1.) To apply for an account");
					System.out.println("Press 2.) To register as an employee");
					System.out.println("Press 3.) To regiser as an admin");
					System.out.println("Press 4.) For Main Menu");
					int choice4 = scan.nextInt(); 
					switch(choice4) {
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
					case 4:
						System.out.println("Taking you the Main Menu");
						startMenu();
					default:
					}
					
					break;
				case 2:
					Scanner employeeLogIn = new Scanner(System.in);
					System.out.println("Enter your user name");
					String  userInput = employeeLogIn.nextLine();
					System.out.println("Enter your password");
					String inputPassword = employeeLogIn.nextLine();
					Employee empass = EmployeeIO.findEmployeePassword(inputPassword);
					Employee employee = EmployeeIO.findEmployeeByUserName(userInput);
					if(employee == null || empass == null) {
						System.out.println("Credentials do not match");
						otherServicesMenu();
					}
					employeeMenu();
					break;
				case 3:
					Scanner adminIn = new Scanner(System.in);
					System.out.println("Enter your user name");
					String adminInput = adminIn.nextLine();
					Admin admin = AdminDAOImpl.findAdminByUserName(adminInput);
					System.out.println("Enter your password");
					String passInput = adminIn.nextLine();
					Admin password = AdminDAOImpl.findAdminPassword(passInput);
					if(admin == null || password == null) {
						System.out.println("Credentials do not match!");
						otherServicesMenu();
					}
					
					adminMenu();
					break;
				case 4: 
					System.out.println("Taking you back to the Main Menu");
					startMenu();
					break;
				case 5:
					System.out.println("Thank you for Banking With Us!");
					System.exit(1);
					break;
				default: 
					System.out.println("Enter a valid option.");
					otherServicesMenu();
					break;
			}
			
		}
		
		public static void employeeMenu() {
			int choice5;
			Scanner sc = new Scanner(System.in);
			Scanner in = new Scanner(System.in);
			System.out.println("Press 1.) to View Customer List");
			System.out.println("Press 2.) to View Customer's information");
			System.out.println("Press 3.) to Approve Applications");
			System.out.println("Press 4.) for Main Menu");
			System.out.println("Press 5.) to exit.");
			choice5 = in.nextInt();
			switch (choice5) {
				case 1:
					System.out.println(CustomerDAOImpl.customerList);
					System.out.println("Press any key then 'enter' to go back to the employee menu");
					sc.next();
					employeeMenu();		
				break;
				case 2:
					Scanner textInput = new Scanner(System.in);
					System.out.println("Enter the Customer's Username.");
					String userName = textInput.nextLine();				
					Customer customer = CustomerDAOImpl.findCustomerByUserName(userName);
					System.out.println(customer);
					System.out.println("Press any key then 'enter' to go back to the employee menu");
					sc.next();
					employeeMenu();	
					break;
				case 3:
					Scanner textInput2 = new Scanner(System.in);
					System.out.println("Enter the Customer's user name.");
					String userName2 = textInput2.nextLine();				
					Customer customer2 = CustomerDAOImpl.findCustomerByUserName(userName2);
					if(customer2.getIsApproved() == false) {
					System.out.println(customer2.getFirstName() + "'s " + "application status is " + customer2.getIsApproved() + "\n Would you like to approve? y/n?");
	
						if(textInput2.nextLine().equalsIgnoreCase("y")) {
							System.out.println("Ok " + customer2.getFirstName() + " has been approved!");
							BankMethods.employeeApproveDeny(customer2);
							CustomerIO.writeCustomerFile();
						}else {
							System.out.println("Ok, the status has stayed the same.");
						}
					
					}else {
						System.out.println("This applicant has been approved already.");
					}
					employeeMenu();
					break;
				case 4: 
					System.out.println("Taking you back to the Main Menu");
					startMenu();
					break;
				case 5:
					System.out.println("Thank you for Banking With Us!");
					System.exit(1);
					break;
				default:
				System.out.println("Please enter a valid choice");
				employeeMenu();
				break;
			}
		}
		
		public static void adminMenu() {
			int choice6;
			Scanner sca = new Scanner(System.in);
			Scanner inte = new Scanner(System.in);
			System.out.println("Press 1.) to View Customer List");
			System.out.println("Press 2.) to View Customer's information");
			System.out.println("Press 3.) to Approve/Deny Applications");
			System.out.println("Press 4.) to Make Transactions on a User's Account");
			System.out.println("Press 5.) for Main Menu");
			System.out.println("Press 6.) Exit ");
			
			choice6 = inte.nextInt();
			switch (choice6) {
				case 1:
					System.out.println(CustomerDAOImpl.customerList);
					System.out.println("Press any key then 'enter' to go back to the employee menu");
					sca.next();
					adminMenu();		
				break;
				case 2:
					Scanner textInput = new Scanner(System.in);
					System.out.println("Enter the Customer's Username.");
					String userName = textInput.nextLine();				
					Customer customer = CustomerDAOImpl.findCustomerByUserName(userName);
					System.out.println(customer);
					System.out.println("Press any key then 'enter' to go back to the employee menu");
					sca.next();
					adminMenu();	
					break;
				case 3:
					Scanner textInput2 = new Scanner(System.in);
					System.out.println("Enter the Customer's Username.");
					String userName2 = textInput2.nextLine();				
					Customer customer2 = CustomerDAOImpl.findCustomerByUserName(userName2);
					System.out.println("Account Status of " + customer2.getFirstName() + " is " + customer2.getIsApproved());
					System.out.println("Would you like to change the status? y/n");
					String answer = textInput2.nextLine();
					if(answer.equalsIgnoreCase("y")) {
						BankMethods.adminApproveDeny(customer2);	
						CustomerIO.writeCustomerFile();
						System.out.println("Ok status has been changed!");
						adminMenu();
					}else {
						System.out.println("Ok status remained the same!");
						adminMenu();
					}
					break;
				case 4:
					adminTransactionsMenu();
					break;
				case 5:
					System.out.println("Taking you back the Main Menu");
					startMenu();
					break;
				case 6:
					System.out.println("Thank you for Banking With Us.");
					System.exit(1);
					break;
			default:
				System.out.println("Please enter a valid choice");
				adminMenu();
				break;
			}
		}
		
		
		public static void adminTransactionsMenu() {
			Scanner ner = new Scanner(System.in);
			Scanner ger = new Scanner(System.in);
			Scanner numDouble = new Scanner(System.in);
			//Withdraw, Deposit, Transfer.
			//Edit first & last name, telephone, password.
			System.out.println("1.) Deposit");
			System.out.println("2.) Withdraw");
			System.out.println("3.) Transfer");
			System.out.println("4.) Edit Customer");
			System.out.println("5.) for Main Menu");
			System.out.println("6.) Exit");
			int answer = ger.nextInt();
			switch (answer) {
			case 1:
				System.out.println("Enter the user name of the account you want to access?");
				String inputUserName = ner.nextLine();
				Customer customer = CustomerDAOImpl.findCustomerByUserName(inputUserName);
				Account account = AccountDAOImpl.findByAccountNumber(customer.getAccountNumber());
				System.out.println("The current balanace is: "+ "$" +account.getAccountBalance());
				System.out.println("How much do you want to deposit?");
				double amount = numDouble.nextDouble();
				BankMethods.deposit(account, amount);
				AccountsIO.writeAccountFile();
				System.out.println("Your new balance is: " + "$" +(account.getAccountBalance()));
				adminTransactionsMenu();
				break;

			case 2:
				System.out.println("Enter the user name of the account you want to access?");
				String newInputUserName = ner.nextLine();
				Customer otherCustomer = CustomerDAOImpl.findCustomerByUserName(newInputUserName);
				Account otherAccount = AccountDAOImpl.findByAccountNumber(otherCustomer.getAccountNumber());
				System.out.println("The current balanace is: "+ "$" + otherAccount.getAccountBalance());
				System.out.println("How much do you want to withdraw?");
				double amount2 = numDouble.nextDouble();
				BankMethods.withdraw(otherAccount, amount2);
				AccountsIO.writeAccountFile();
				System.out.println("Your new balance is: " + "$" + (otherAccount.getAccountBalance()));
				adminTransactionsMenu();
				break;

			case 3:
				System.out.println("Enter the user name of the account you want to transfer from.");
				String account1Input = ner.nextLine();
				Customer customer1 = CustomerDAOImpl.findCustomerByUserName(account1Input);
				Account account1 = AccountDAOImpl.findByAccountNumber(customer1.getAccountNumber());
				System.out.println("Enter the user name of the account you want to transfer to.");
				String account2Input = ner.nextLine();
				Customer customer2 = CustomerDAOImpl.findCustomerByUserName(account2Input);
				Account account2 = AccountDAOImpl.findByAccountNumber(customer2.getAccountNumber());
				System.out.println("How much money do you want to transfer?");
				System.out.println(customer1.getFirstName()+ "'s "+ "acccount balance is: $" + account1.getAccountBalance());
				System.out.println(customer2.getFirstName()+ "'s "+ "acccount balance is: $" + account2.getAccountBalance());
				double amount3 = numDouble.nextDouble();
				BankMethods.transfer(account1, account2, amount3);
				AccountsIO.writeAccountFile();
				System.out.println(customer1.getFirstName()+ "'s "+ "acccount balance is now: $" + (account1.getAccountBalance()));
				System.out.println(customer2.getFirstName()+ "'s "+ "acccount balance is now: $" + (account2.getAccountBalance()));
				adminTransactionsMenu();
				break;
			case 4:
				System.out.println("Enter the user name of the account you want to access?");
				String userInput = ner.nextLine();
				Customer theCustomer = CustomerDAOImpl.findCustomerByUserName(userInput);
				if(theCustomer == null) {
					adminTransactionsMenu();
				}
				editMenu(theCustomer);
				break;
			case 5:
				System.out.println("Taking you back to Main Menu.");
				startMenu();
				break;
			case 6:
				System.out.println("Thank you for Banking With Us!");
				System.exit(1);
				break;
			default:
				System.out.println("Not a valid entry, try a different input.");
				break;
			}
			
		}
		
		public static void editMenu(Customer customer) {
			Scanner intScan = new Scanner(System.in);
			Scanner textScan = new Scanner(System.in);
			Scanner longScan = new Scanner(System.in);
			System.out.println("What would you like to edit?");
			System.out.println("1.) First Name   2.) Last Name   3.)User Name   4.)Password   5.)Telephone Number 6.) Admin Menu");
			int answer = intScan.nextInt();
			switch (answer) {
			case 1:
				System.out.println("Please enter a first name.");
				String firstName = textScan.nextLine();
				customer.setFirstName(firstName);
				CustomerIO.writeCustomerFile();
				System.out.println("First name has been updated.");
				System.out.println(customer);
				adminTransactionsMenu();
				break;

			case 2:
				System.out.println("Please enter a last name.");
				String lastName = textScan.nextLine();
				customer.setLastName(lastName);
				CustomerIO.writeCustomerFile();
				System.out.println("Last name has been updated.");
				System.out.println(customer);
				adminTransactionsMenu();
				break;

			case 3:
				System.out.println("Please enter a new user name.");
				String userName = textScan.nextLine();
				customer.setUserName(userName);
				CustomerIO.writeCustomerFile();
				System.out.println("User Name has been updated.");
				System.out.println(customer);
				adminTransactionsMenu();
				break;

			case 4:
				System.out.println("Please enter a new password.");
				String password = textScan.nextLine();
				customer.setPassword(password);
				CustomerIO.writeCustomerFile();
				System.out.println("Password has been updated.");
				System.out.println(customer);
				adminTransactionsMenu();
				break;

			case 5:
				System.out.println("Please enter the new number.");
				Long telephone = longScan.nextLong();
				customer.setPhoneNumber(telephone);
				CustomerIO.writeCustomerFile();
				System.out.println("Number has been updated.");
				System.out.println(customer);
				adminTransactionsMenu();
				break;
			case 6:
				System.out.println("Return to Admin Transaction's Menu");
				adminTransactionsMenu();
				break;
			default:
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
//=============Currency Format============
		/*
		 * double amt = 123.456;    

			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			System.out.println(formatter.format(amt));
		 */
}
