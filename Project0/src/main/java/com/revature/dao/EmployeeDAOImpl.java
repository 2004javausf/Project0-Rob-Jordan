package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.io.AccountsIO;
import com.revature.io.CustomerIO;
import com.revature.io.EmployeeIO;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public static List<Employee> employeeList = new ArrayList<Employee>();
	
	@Override
	public void createEmployee() {
		EmployeeIO.readEmployeeFile();
		AccountsIO.readAccountFile();
		List<Employee> eList = EmployeeDAOImpl.employeeList;
		List<Account>  accList = AccountDAOImpl.accountList;
		Scanner intInput = new Scanner(System.in);
		Scanner textInput = new Scanner(System.in);
		Scanner longInput = new Scanner(System.in);
		int answer = 0;

		int employeeId;
		String firstName;
		String lastName;
		String userName;
		String password;	
		int status_code = 2;

		//END OF STATUS CODE BLOCK
			System.out.println("What is your first name?");
			firstName = textInput.nextLine();
			System.out.println("What is your last name?");
			lastName = textInput.nextLine();
			System.out.println("Make a user name.");
			userName = textInput.nextLine();
			for (int i = 0; i < eList.size(); i++) {
				while (userName.equals(eList.get(i).getUserName())) {
					System.out.println("That name has been taken. Try another one.");
					userName = textInput.nextLine();
				}
			}
			System.out.println("Come up with a password.");
			password = textInput.nextLine();
			
			System.out.println("Would you like to make another account? Y/N");
			String choice = textInput.nextLine();
			if(choice.equalsIgnoreCase("y")) {
				createEmployee();
			}else if(choice.equalsIgnoreCase("n")) {
				System.out.println("Thank you!");
			}
			
			Employee  employee = new Employee(1, firstName, lastName, userName, password, status_code);
			
		}
	
	public static Employee findEmployeeByUserName(String inputUserName) {
		for(int i = 0; i < EmployeeDAOImpl.employeeList.size(); i++) {
			String name = EmployeeDAOImpl.employeeList.get(i).getUserName();
			if(inputUserName.equals(name)) {
				return EmployeeDAOImpl.employeeList.get(i);
			}
		}
		System.out.println("Employee not found");
		
		return null;
	}


	@Override
	public List<Object> getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
