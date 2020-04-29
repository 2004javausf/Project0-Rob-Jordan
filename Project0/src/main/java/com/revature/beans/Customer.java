package com.revature.beans;

import java.io.Serializable;

import com.revature.dao.CustomerDAOImpl;
import com.revature.io.CustomerIO;

public class Customer implements Serializable {
	


	private static final long serialVersionUID = -400595318687091282L;
	
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int accountNumber;
	private long phoneNumber;
	private int statusCode;
	private boolean isApproved;
	
	public Customer() {
		super();
		CustomerDAOImpl.customerList.add(this);
		CustomerIO.writeCustomerFile();
	}
	
	
	public Customer(int customerId, String firstName, String lastName, String userName, String password,
			int accountNumber, long phoneNumber, int statusCode, boolean isApproved) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.statusCode = statusCode;
		CustomerDAOImpl.customerList.add(this);
		CustomerIO.writeCustomerFile();
	}
	
	public Customer(int customerId, String firstName, String lastName, String userName, String password,
		int accountNumber, int statusCode) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.statusCode = statusCode;
		CustomerDAOImpl.customerList.add(this);
		CustomerIO.writeCustomerFile();
	}
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", password=" + password + ", accountNumber=" + accountNumber
				+ ", phoneNumber=" + phoneNumber + ", statusCode=" + statusCode + "]";
	}
	

}
