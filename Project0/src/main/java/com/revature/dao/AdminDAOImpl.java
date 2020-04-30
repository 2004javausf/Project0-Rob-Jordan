package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Admin;
import com.revature.beans.Employee;
import com.revature.io.AccountsIO;
import com.revature.io.AdminIO;
import com.revature.io.EmployeeIO;

public class AdminDAOImpl implements AdminDAO{
	
	public static List<Admin> adminList = new ArrayList<Admin>();
	
	public void createAdmin() {
		AdminIO.readAdminFile();
		AccountsIO.readAccountFile();
		List<Admin> aList = AdminDAOImpl.adminList;
		List<Account>  accList = AccountDAOImpl.accountList;
		Scanner intInput = new Scanner(System.in);
		Scanner textInput = new Scanner(System.in);
		Scanner longInput = new Scanner(System.in);
		int answer = 0;

		int adminId;
		String firstName;
		String lastName;
		String userName;
		String password;	
		int status_code = 3;

		//END OF STATUS CODE BLOCK
			System.out.println("What is your first name?");
			firstName = textInput.nextLine();
			System.out.println("What is your last name?");
			lastName = textInput.nextLine();
			System.out.println("Make a user name.");
			userName = textInput.nextLine();
			for (int i = 0; i < aList.size(); i++) {
				while (userName.equals(aList.get(i).getUserName())) {
					System.out.println("That name has been taken. Try another one.");
					userName = textInput.nextLine();
				}
			}
			System.out.println("Come up with a password.");
			password = textInput.nextLine();
			
			System.out.println("Would you like to make another account? Y/N");
			String choice = textInput.nextLine();
			if(choice.equalsIgnoreCase("y")) {
				createAdmin();
			}else if(choice.equalsIgnoreCase("n")) {
				System.out.println("Thank you!");
			}
			
			Admin  admin = new Admin(1, firstName, lastName, userName, password, status_code);
			
		}
	
	public static Admin findAdminByUserName(String inputUserName) {
		for(int i = 0; i < AdminDAOImpl.adminList.size(); i++) {
			String name = AdminDAOImpl.adminList.get(i).getUserName();
			if(inputUserName.equals(name)) {
				return AdminDAOImpl.adminList.get(i);
			}
		}
		System.out.println("Admin not found");
		
		return null;
	}

	public List<Object> getAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

}
