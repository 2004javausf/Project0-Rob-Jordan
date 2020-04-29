package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public void createEmployee();
	public List<Object> getEmployee();
	public Employee findEmployeeByUserName(String inputUserName);

}
