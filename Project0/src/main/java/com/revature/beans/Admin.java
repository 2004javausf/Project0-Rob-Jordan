package com.revature.beans;

import java.io.Serializable;

import com.revature.dao.AdminDAOImpl;
import com.revature.io.AdminIO;

public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4723938589558393223L;
	private int adminID;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int status_code;
	
	public Admin(int adminID, String firstName, String lastName, String userName, String password, int status_code) {
		super();
		this.adminID = adminID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.status_code = status_code;
		
		AdminDAOImpl.adminList.add(this);
		AdminIO.writeAdminFile();
	}

	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
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

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", status_code=" + status_code + "]";
	}
	
}
