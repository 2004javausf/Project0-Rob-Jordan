package com.revature.driver;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.io.AccountsIO;
import com.revature.io.CustomerIO;
import com.revature.io.EmployeeIO;
import com.revature.menu.Menu;

public class AccountDriver {
	
	
			

	public static void main(String[] args) {
		CustomerIO.readCustomerFile();
		AccountsIO.readAccountFile();
		EmployeeIO.readEmployeeFile();
//		System.out.println(EmployeeDAOImpl.employeeList);

		Menu.startMenu();
		
	}

}
