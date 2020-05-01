package com.revature.adminmethodstest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.beans.Admin;
import com.revature.dao.AdminDAOImpl;

class AdminMethodsTest {

	Admin rob = new Admin(1, "Roberth", "Torres", "Robb", "1234", 3);
	Admin jP = new Admin(2, "Jordan", "Parker", "JP", "4321", 3);

	@Test
	void userNameValidationTest() {
		AdminDAOImpl.findAdminByUserName("The Guy");
		//expected, actual
		assertEquals("Jordan", jP.getFirstName());
		
	}
	
	@Test
	void passwordValidationTest() {
		AdminDAOImpl.findAdminByUserName("1234");
		//expected, actual
		assertEquals("Roberth", rob.getFirstName());
		
	}

}
