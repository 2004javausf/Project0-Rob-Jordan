package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Admin;
import com.revature.dao.AdminDAOImpl;

public class AdminIO {
	
private static final String adminFile = "admins.txt";

	
	public static void writeAdminFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(adminFile));
			objectOut.writeObject(AdminDAOImpl.adminList);
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
	public static void  readAdminFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(adminFile));
			AdminDAOImpl.adminList = (ArrayList<Admin>) objectIn.readObject();
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
