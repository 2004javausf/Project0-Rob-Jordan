package com.revature.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IO {
	//Write data to a file.
	
	public void writeOutputStreamContents(String contents) {
		OutputStream os = null;
		File file = new File("applicants.txt");
		try {
			os = new FileOutputStream(file, true);
			os.write(contents.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(os != null) {
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//=======READ A STRING FROM A FILE==========================================//
	
	public String readInputStreamContents() {
		InputStream is = null;
		File file = new File("applicants.txt");
		StringBuilder s = new StringBuilder();
		
		try {
			is = new FileInputStream(file);
			int b = 0;
			while((b = is.read()) != -1) {
				char c = (char) b;
				s.append(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s.toString();
	}
}
