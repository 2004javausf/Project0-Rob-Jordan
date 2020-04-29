package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Employee;
import com.revature.io.EmployeeIO;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public static List<Employee> employeeList = new ArrayList<Employee>();


	@Override
	public List<Object> getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeByName(String inputName) {
		EmployeeIO.readEmployeeFile();
		return null;
	}
	
	public void approveOrDenyApplication() {
		Scanner ints = new Scanner(System.in);
		Scanner strings = new Scanner(System.in);
		
		
	}


		
}
