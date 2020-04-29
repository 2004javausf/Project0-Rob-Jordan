package com.revature.beans;

import java.io.Serializable;

import com.revature.dao.CustomerDAOImpl;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.io.CustomerIO;
import com.revature.io.EmployeeIO;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -400082951008083066L;
	
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public Employee() {
		super();
		EmployeeDAOImpl.employeeList.add(this);
		EmployeeIO.writeEmployeeFile();
	}
	
	
	public Employee(int employeeId, String firstName, String lastName, String username, String password) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		EmployeeDAOImpl.employeeList.add(this);
		EmployeeIO.writeEmployeeFile();
	}


	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}
