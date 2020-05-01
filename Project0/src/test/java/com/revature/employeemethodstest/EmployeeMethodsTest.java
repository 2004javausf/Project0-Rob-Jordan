package com.revature.employeemethodstest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.beans.Employee;
import com.revature.io.EmployeeIO;

class EmployeeMethodsTest {
	
	Employee rob = new Employee(1, "Rob", "Torres", "Robster", "1234", 2);
	Employee jP = new Employee(2, "JPeter", "Parker", "The Guy", "4321", 2);

	@Test
	void userNameValidationTest() {
		EmployeeIO.findEmployeeByUserName("The Guy");
		//expected, actual
		assertEquals("JPeter", jP.getFirstName());
		
	}
	
	@Test
	void passwordValidationTest() {
		EmployeeIO.findEmployeeByUserName("1234");
		//expected, actual
		assertEquals("Rob", rob.getFirstName());
		
	}

}
