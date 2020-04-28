package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public static List<Employee> employeeList = new ArrayList<Employee>();
	
	//to find an employee by first name
	public Employee findEmployeeByName(String inputName) {
		for(int i = 0; i < employeeList.size(); i++) {
			String name = employeeList.get(i).getFirstName();
			if(inputName.equals(name)) {
				return employeeList.get(i);
			}
		}
		System.out.println("Employee not found");
		
		return null;
	}

	@Override
	public void createEmployee() {
		
		
	}

	@Override
	public List<Object> getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
