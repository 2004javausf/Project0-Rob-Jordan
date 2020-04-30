package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.EmployeeDAOImpl;

public class EmployeeIO extends Employee{
/**
	 * 
	 */
	private static final long serialVersionUID = -5539244316075141467L;
private static final String employeeFile = "employees.txt";

	
	public static void writeEmployeeFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(employeeFile));
			objectOut.writeObject(EmployeeDAOImpl.employeeList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void  readEmployeeFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(employeeFile));
			EmployeeDAOImpl.employeeList = (ArrayList<Employee>) objectIn.readObject();
			objectIn.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public static Employee findEmployeePassword(String inputPassword) {
		for(int i = 0; i < EmployeeDAOImpl.employeeList.size(); i++) {
			String password = EmployeeDAOImpl.employeeList.get(i).getPassword();
			if(inputPassword.equals(password)) {
				return EmployeeDAOImpl.employeeList.get(i);
			}
		}
		System.out.println("Password does not match");
		
		return null;
	}
}
