package com.revature.customermethodstest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAOImpl;

class CustomerMethodsTest {

	Customer rob = new Customer(1, "Rob", "Torres", "Robster", "1234", 49498958, 1);
	Customer jP = new Customer(2, "JPeter", "Parker", "The Guy", "4321", 3049494, 1);

	@Test
	void userNameValidationTest() {
		CustomerDAOImpl.findCustomerByUserName("The Guy");
		//expected, actual
		assertEquals("JPeter", jP.getFirstName());
		
	}
	
	@Test
	void passwordValidationTest() {
		CustomerDAOImpl.findCustomerByUserName("1234");
		//expected, actual
		assertEquals("Rob", rob.getFirstName());
		
	}

}
