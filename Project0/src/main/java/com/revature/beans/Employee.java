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
	private String userName;
	private String password;
	private int status_code;
	
	public Employee() {
		super();
		EmployeeDAOImpl.employeeList.add(this);
		EmployeeIO.writeEmployeeFile();
	}
	
	
	public Employee(int employeeId, String firstName, String lastName, String userName, String password, int status_code) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.status_code = status_code;
		EmployeeDAOImpl.employeeList.add(this);
		EmployeeIO.writeEmployeeFile();
	}


	public int getStatus_code() {
		return status_code;
	}


	public void setStatus_code(int status_code) {
		this.status_code = status_code;
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
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
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
				+ ", userName=" + userName + ", password=" + password + ", status_code=" + status_code + "]";
	}



	
}
