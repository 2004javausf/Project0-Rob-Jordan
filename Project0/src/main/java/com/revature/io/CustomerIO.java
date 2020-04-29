package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAOImpl;

public class CustomerIO {
	private static final String applicantsFile = "applicants.txt";

	
	public static void writeCustomerFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(applicantsFile));
			objectOut.writeObject(CustomerDAOImpl.customerList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void  readCustomerFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(applicantsFile));
			CustomerDAOImpl.customerList = (ArrayList<Customer>) objectIn.readObject();
			objectIn.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
