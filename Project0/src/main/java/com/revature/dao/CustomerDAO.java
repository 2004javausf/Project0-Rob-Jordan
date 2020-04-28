package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.beans.Employee;

public interface CustomerDAO {
	
	public void createCustomer();
	public List<Object> getCustomers();
	
public static List<Customer> customerList = new ArrayList<Customer>();
	
	//to find a customer by first name
	public static Customer findCustomerByName(String inputName) {
		for(int i = 0; i < customerList.size(); i++) {
			String name = customerList.get(i).getFirstName();
			if(inputName.equals(name)) {
				return customerList.get(i);
			}
		}
		System.out.println("Customer not found");
		
		return null;
	}
}
