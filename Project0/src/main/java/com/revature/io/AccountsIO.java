package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.dao.AccountDAOImpl;

public class AccountsIO {

private static final String accountsFile = "accounts.txt";

	
	public static void writeAccountFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(accountsFile));
			objectOut.writeObject(AccountDAOImpl.accountList);
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
	public static void  readAccountFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(accountsFile));
			AccountDAOImpl.accountList = (ArrayList<Account>) objectIn.readObject();
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
