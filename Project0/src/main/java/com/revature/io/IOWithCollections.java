package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;

public class IOWithCollections {
	private static final String applicantsFile = "applicants.txt";
	public static List<Customer> customerList = new ArrayList<Customer>();
	public static List<Object> otherCustomerList = new ArrayList<Object>();
	
	public static void writeHumanFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(applicantsFile, true));
			objectOut.writeObject(customerList);
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
	public static Object readHumanFile() {
		boolean cont = true;
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(applicantsFile));
			while(cont) {
				Object obj = null;
				try {
					obj = (Customer) objectIn.readObject();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				if(obj != null) {
					otherCustomerList.add(obj);
				} else {
					cont = false;
				}
			}
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return otherCustomerList;
	}
	

}
